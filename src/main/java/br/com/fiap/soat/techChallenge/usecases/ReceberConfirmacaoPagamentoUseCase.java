package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.exceptions.ConfirmacaoDePagamentoInvalidaException;
import br.com.fiap.soat.techChallenge.exceptions.PedidoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ReceberConfirmacaoPagamentoUseCasePort;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeConfirmacaoDePagamento;

import java.util.Optional;
import java.util.UUID;

public class ReceberConfirmacaoPagamentoUseCase implements ReceberConfirmacaoPagamentoUseCasePort {
    private final PedidoGatewayPort pedidoGateway;

    public ReceberConfirmacaoPagamentoUseCase(PedidoGatewayPort pedidoGateway) {

        this.pedidoGateway = pedidoGateway;
    }

    public String execute(ComandoDeConfirmacaoDePagamento comandoDeConfirmacaoDePagamento) {
        String action = comandoDeConfirmacaoDePagamento.getAction();
        if (! action.equals("payment.created")) {
            throw ConfirmacaoDePagamentoInvalidaException.aPartirDaAction(action);
        }

        UUID pagamentoId = comandoDeConfirmacaoDePagamento.getPagamentoId();
        Optional<Pedido> pedidoO = pedidoGateway.obterPedidoComPagamentoId(pagamentoId);
        if (pedidoO.isEmpty()) {
            throw PedidoNaoEncontradoException.aPartirDoPagamentoId(pagamentoId);
        }
        
        Pedido pedido = pedidoO.get();
        pedido.setStatusDoPagamento(StatusDoPagamento.APROVADO);
        pedido.setStatusDoPedido(StatusDoPedido.EM_PREPARACAO);
        pedidoGateway.atualizarPedido(pedido);
        return String.format("Pagamento %s confirmado", pagamentoId);
    }
}
