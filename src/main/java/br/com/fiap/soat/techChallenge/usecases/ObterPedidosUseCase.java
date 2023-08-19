package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoRepositoryPort;

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