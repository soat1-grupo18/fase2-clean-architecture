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
import java.time.LocalDateTime;
import java.util.UUID;

public class FazerCheckoutPedidoUseCase implements FazerCheckoutPedidoUseCasePort {
    private final PedidoGatewayPort pedidoGateway;
    private final ProdutoGatewayPort produtoGateway;
    private final ClienteGatewayPort clienteGateway;

    public FazerCheckoutPedidoUseCase(
            PedidoGatewayPort pedidoGateway,
            ProdutoGatewayPort produtoGateway,
            ClienteGatewayPort clienteGateway
    ) {
        this.pedidoGateway = pedidoGateway;
        this.produtoGateway = produtoGateway;
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        pedido.setStatusDoPedido(StatusDoPedido.RECEBIDO);
        pedido.setStatusDoPagamento(StatusDoPagamento.PENDENTE);
        pedido.setDataDeCriacao(LocalDateTime.now());

        // TODO Integrar com Mercado Pago para obter ID de pagamento
        pedido.setPagamentoId(UUID.randomUUID());

        if (comandoDeNovoPedido.getClienteId() != null) {
            Cliente cliente = clienteGateway
                    .identificaPorId(comandoDeNovoPedido.getClienteId())
                    .orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoId(comandoDeNovoPedido.getClienteId()));

            pedido.setClienteId(cliente.getId());
        }


        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            Produto produto = produtoGateway
                    .identificarPorId(itemSolicitado.getProdutoId())
                    .orElseThrow(() -> ProdutoNaoEncontradoException.aPartirDeProdutoId(itemSolicitado.getProdutoId()));

            ItemDoPedido item = new ItemDoPedido(
                    null,
                    produto.getNome(),
                    produto.getDescricao(),
                    produto.getCategoria().toString(),
                    produto.getImagem(),
                    itemSolicitado.getQuantidade(),
                    BigDecimal.valueOf(produto.getPreco())
            );

            pedido.adicionarItem(item);
        }

        return pedidoGateway.inserirPedido(pedido);
    }
}
