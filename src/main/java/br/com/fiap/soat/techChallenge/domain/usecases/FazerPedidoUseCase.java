package br.com.fiap.soat.techChallenge.domain.usecases;

import br.com.fiap.soat.techChallenge.domain.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.domain.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.usecases.model.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.domain.usecases.model.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.PedidoRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.FazerPedidoUseCasePort;
import br.com.fiap.soat.techChallenge.entities.*;

import java.math.BigDecimal;

public class FazerPedidoUseCase implements FazerPedidoUseCasePort {
    private final PedidoRepositoryPort pedidoRepositoryPort;
    private final ProdutoRepositoryPort produtoRepositoryPort;
    private final ClienteRepositoryPort clienteRepositoryPort;

    public FazerPedidoUseCase(
            PedidoRepositoryPort pedidoRepositoryPort,
            ProdutoRepositoryPort produtoRepositoryPort,
            ClienteRepositoryPort clienteRepositoryPort
    ) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        pedido.setStatus(StatusDoPedido.PAGAMENTO_PENDENTE);

        if (comandoDeNovoPedido.getClienteId() != null) {
            Cliente cliente = clienteRepositoryPort
                    .identificaPorId(comandoDeNovoPedido.getClienteId())
                    .orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoId(comandoDeNovoPedido.getClienteId()));

            pedido.setClienteId(cliente.getId());
        }


        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            Produto produto = produtoRepositoryPort
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

        return pedidoRepositoryPort.inserirPedido(pedido);
    }
}
