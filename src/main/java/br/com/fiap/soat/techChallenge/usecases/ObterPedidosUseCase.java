package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;

import java.util.List;

public class ObterPedidosUseCase implements ObterPedidosUseCasePort {
    private final PedidoGatewayPort pedidoGateway;

    public ObterPedidosUseCase(PedidoGatewayPort pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> execute() {
        List<Pedido> pedidos = pedidoGateway.obterPedidos();

        return pedidos;
    }
}
