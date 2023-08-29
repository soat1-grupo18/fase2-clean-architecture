package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterTodosPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;

import java.util.List;

public class ObterTodosPedidosUseCase implements ObterTodosPedidosUseCasePort {
    private final PedidoGatewayPort pedidoGateway;

    public ObterTodosPedidosUseCase(PedidoGatewayPort pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> execute() {
        return pedidoGateway.obterTodosPedidos();
    }
}
