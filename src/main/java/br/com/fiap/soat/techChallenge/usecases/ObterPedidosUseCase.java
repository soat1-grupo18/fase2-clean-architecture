package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;

import java.util.List;

public class ObterPedidosUseCase implements ObterPedidosUseCasePort {
    private final PedidoGatewayPort pedidoGatewayPort;

    public ObterPedidosUseCase(PedidoGatewayPort pedidoGatewayPort) {
        this.pedidoGatewayPort = pedidoGatewayPort;
    }

    @Override
    public List<Pedido> execute() {
        List<Pedido> pedidos = pedidoGatewayPort.obterPedidos();

        return pedidos;
    }
}
