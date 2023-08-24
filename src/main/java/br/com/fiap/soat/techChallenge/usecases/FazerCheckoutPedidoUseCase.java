package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.usecases.model.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.FazerCheckoutPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.entities.*;

import java.math.BigDecimal;

public class FazerCheckoutPedidoUseCase implements FazerCheckoutPedidoUseCasePort {
    private final PedidoGatewayPort pedidoGatewayPort;
    private final ProdutoGatewayPort produtoGatewayPort;
    private final ClienteGatewayPort clienteGatewayPort;

    public FazerCheckoutPedidoUseCase(
            PedidoGatewayPort pedidoGatewayPort,
            ProdutoGatewayPort produtoGatewayPort,
            ClienteGatewayPort clienteGatewayPort
    ) {
        this.pedidoGatewayPort = pedidoGatewayPort;
        this.produtoGatewayPort = produtoGatewayPort;
        this.clienteGatewayPort = clienteGatewayPort;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        pedido.setStatus(StatusDoPedido.RECEBIDO);

        if (comandoDeNovoPedido.getClienteId() != null) {
            Cliente cliente = clienteGatewayPort
                    .identificaPorId(comandoDeNovoPedido.getClienteId())
                    .orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoId(comandoDeNovoPedido.getClienteId()));

            pedido.setClienteId(cliente.getId());
        }


        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            Produto produto = produtoGatewayPort
                    .identificarPorId(itemSolicitado.getProdutoId())
                    .orElseThrow(() -> ProdutoNaoEncontradoException.aPartirDeProdutoId(itemSolicitado.getProdutoId()));

            ItemDoPedido item = new ItemDoPedido(
                    null,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getCategoria().toString(),
                    produto.getImagem(),
                    itemSolicitado.getQuantidade(),
                    new BigDecimal(produto.getPreco())
            );

            pedido.adicionarItem(item);
        }

        return pedidoGatewayPort.inserirPedido(pedido);
    }
}
