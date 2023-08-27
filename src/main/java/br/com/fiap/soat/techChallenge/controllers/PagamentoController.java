package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.interfaces.usecases.ConsultarStatusPagamentoUseCasePort;
import br.com.fiap.soat.techChallenge.presenters.PagamentoPresenter;

import java.util.UUID;

public class PagamentoController {

    private final ConsultarStatusPagamentoUseCasePort consultarStatusPagamentoUseCase;

    public PagamentoController(ConsultarStatusPagamentoUseCasePort consultarStatusPagamentoUseCase) {

        this.consultarStatusPagamentoUseCase = consultarStatusPagamentoUseCase;
    }

    public PagamentoPresenter consultarStatusPagamento(UUID pedidoId) {
        Boolean pagamentoAprovado = consultarStatusPagamentoUseCase.execute(pedidoId);
        return new PagamentoPresenter(pagamentoAprovado);
    }
}
