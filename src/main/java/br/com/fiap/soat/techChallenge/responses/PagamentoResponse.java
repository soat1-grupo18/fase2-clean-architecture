package br.com.fiap.soat.techChallenge.responses;

import br.com.fiap.soat.techChallenge.entities.Pedido;

public class PagamentoResponse {

    private final Boolean pagamentoAprovado;

    public PagamentoResponse(Boolean pagamentoAprovado) {

        this.pagamentoAprovado = pagamentoAprovado;
    }

    public boolean isPagamentoAprovado() {
        return pagamentoAprovado;
    }
}
