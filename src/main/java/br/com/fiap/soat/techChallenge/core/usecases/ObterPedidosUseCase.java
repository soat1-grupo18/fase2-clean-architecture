package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.PedidoRepositoryPort;

import java.util.List;

public class ObterPedidosUseCase implements ObterPedidosUseCasePort {
    private final PedidoRepositoryPort pedidoRepositoryPort;

    public ObterPedidosUseCase(PedidoRepositoryPort pedidoRepositoryPort) {
        this.pedidoRepositoryPort = pedidoRepositoryPort;
    }

    @Override
    public List<Pedido> execute() {
        List<Pedido> pedidos = pedidoRepositoryPort.obterPedidos();

        return pedidos;
    }
}
