package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.exceptions.StatusPedidoNaoAtualizadoException;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.AtualizarStatusPedidoUseCasePort;

import java.util.UUID;

public class AtualizarStatusPedidoUseCase implements AtualizarStatusPedidoUseCasePort {

    private final PedidoGatewayPort pedidoGateway;

    public AtualizarStatusPedidoUseCase(PedidoGatewayPort pedidoGateway) {
        this.pedidoGateway = pedidoGateway;
    }
    @Override
    public Pedido execute(UUID pedidoId, StatusDoPedido statusDoPedido) {
        var pedido = pedidoGateway.obterPedido(pedidoId);

        if (! pedido.isPagamentoAprovado()) {
            throw StatusPedidoNaoAtualizadoException.porPagamentoNaoAprovado();
        }
        if (! pedido.getStatusDoPedido().podeAtualizarPara(statusDoPedido)) {
            throw StatusPedidoNaoAtualizadoException.porProximoStatusInvalido(pedido.getStatusDoPedido(), statusDoPedido);
        }

        pedido.setStatusDoPedido(statusDoPedido);
        pedidoGateway.atualizarPedido(pedido);
        return pedido;
    }
}
