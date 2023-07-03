package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.ItemDoPedido;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;
import br.com.fiap.soat.techChallenge.core.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.usecases.models.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.usecases.models.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.ports.outbound.PedidoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.FazerPedidoUseCasePort;

import java.math.BigDecimal;

public class FazerPedidoUseCase implements FazerPedidoUseCasePort {
    private PedidoRepositoryPort pedidoRepositoryPort;
    private ProdutoRepositoryPort produtoRepositoryPort;

    public FazerPedidoUseCase(PedidoRepositoryPort pedidoRepositoryPort, ProdutoRepositoryPort produtoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        pedido.setClienteId(comandoDeNovoPedido.getClienteId());
        pedido.setStatus(StatusDoPedido.PAGAMENTO_PENDENTE);

        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            Produto produto = produtoRepositoryPort.identificaPorId(itemSolicitado.getProdutoId()).orElseThrow(() -> new ProdutoNaoEncontradoException());

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
