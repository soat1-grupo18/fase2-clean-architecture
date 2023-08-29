package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterPedidosEmAndamentoUseCasePort;

import java.util.List;

public class ObterPedidosEmAndamentoUseCase implements ObterPedidosEmAndamentoUseCasePort {

    private final PedidoGatewayPort pedidoGateway;

    public ObterPedidosEmAndamentoUseCase(PedidoGatewayPort pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }

    @Override
    public List<Pedido> execute() {
        return pedidoGateway.obterPedidosEmAndamento();
    }
}
