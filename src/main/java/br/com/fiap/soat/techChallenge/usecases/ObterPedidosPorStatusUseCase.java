package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosPorStatusUseCasePort;

import java.util.List;

public class ObterPedidosPorStatusUseCase implements ObterPedidosPorStatusUseCasePort {

    private final PedidoGatewayPort pedidoGateway;

    public ObterPedidosPorStatusUseCase(PedidoGatewayPort pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> execute(StatusDoPedido[] statuses) {
        return pedidoGateway.obterPedidosPorStatus(statuses);
    }
}

