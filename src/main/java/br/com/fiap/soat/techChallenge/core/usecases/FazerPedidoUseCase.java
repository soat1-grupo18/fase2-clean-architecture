package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.ItemDoPedido;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;
import br.com.fiap.soat.techChallenge.core.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaProdutoAdapterPort;
import br.com.fiap.soat.techChallenge.core.usecases.models.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.usecases.models.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.ports.driven.PedidoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.FazerPedidoUseCasePort;

import java.math.BigDecimal;
import java.util.UUID;

public class FazerPedidoUseCase implements FazerPedidoUseCasePort {
    private PedidoRepositoryPort pedidoRepositoryPort;
    private IdentificaProdutoAdapterPort identificaProdutoAdapterPort;

    public FazerPedidoUseCase(PedidoRepositoryPort pedidoRepositoryPort, IdentificaProdutoAdapterPort identificaProdutoAdapterPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
        this.identificaProdutoAdapterPort = identificaProdutoAdapterPort;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        pedido.setClienteId(comandoDeNovoPedido.getClienteId());
        pedido.setStatus(StatusDoPedido.PAGAMENTO_PENDENTE);

        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            Produto produto = identificaProdutoAdapterPort.identificaPorId(itemSolicitado.getProdutoId()).orElseThrow(() -> new ProdutoNaoEncontradoException());

            ItemDoPedido item = new ItemDoPedido(
                    null,
                    produto.getNome(),
                    produto.getDescrição(),
                    produto.getCategoria().toString(),
                    produto.getImagem(),
                    itemSolicitado.getQuantidade(),
                    new BigDecimal(produto.getPreço())
            );

            pedido.adicionarItem(item);
        }

        return pedidoRepositoryPort.inserirPedido(pedido);
    }
}
