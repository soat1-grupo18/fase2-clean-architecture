package br.com.fiap.soat.techChallenge.exceptions;

import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

public class StatusPedidoNaoAtualizadoException extends RuntimeException {

    StatusPedidoNaoAtualizadoException(String message) { super(message); }

    public static StatusPedidoNaoAtualizadoException porPagamentoNaoAprovado() {
        return new StatusPedidoNaoAtualizadoException("Não é possível atualizar status de um pedido enquanto o pagamento não foi aprovado.");
    }

    public static StatusPedidoNaoAtualizadoException porProximoStatusInvalido(StatusDoPedido statusAnterior, StatusDoPedido statusProximo) {
        return new StatusPedidoNaoAtualizadoException(String.format("Não é possível atualizar para o status %s um pedido com status %s.", statusProximo, statusAnterior));
    }
}
