package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.ItemDoPedido;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;
import br.com.fiap.soat.techChallenge.core.model.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.model.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.ports.driven.PedidoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.FazerPedidoUseCasePort;

import java.math.BigDecimal;
import java.util.UUID;

public class FazerPedidoUseCase implements FazerPedidoUseCasePort {
    private PedidoRepositoryPort pedidoRepositoryPort;

    public FazerPedidoUseCase(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido) {
        Pedido pedido = new Pedido();

        for (ItemDoComandoDeNovoPedido itemSolicitado : comandoDeNovoPedido.getItens()) {
            // TODO: pesquisar item na base de dados
            ItemDoPedido item = new ItemDoPedido(UUID.randomUUID(), "item fake", "descricao fake", 1, new BigDecimal(10));

            pedido.adicionarItem(item);
        }

        pedido.setStatus(StatusDoPedido.PAGAMENTO_PENDENTE);

        pedidoRepositoryPort.inserirPedido(pedido);

        return pedido;
    }
}
