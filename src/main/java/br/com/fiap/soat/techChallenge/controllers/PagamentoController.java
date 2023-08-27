package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.interfaces.usecases.ConsultarStatusPagamentoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ReceberConfirmacaoPagamentoUseCasePort;
import br.com.fiap.soat.techChallenge.presenters.PagamentoPresenter;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeConfirmacaoDePagamento;

import java.util.UUID;

public class PagamentoController {

    private final ConsultarStatusPagamentoUseCasePort consultarStatusPagamentoUseCase;
    private final ReceberConfirmacaoPagamentoUseCasePort receberConfirmacaoPagamentoUseCase;

    public PagamentoController(ConsultarStatusPagamentoUseCasePort consultarStatusPagamentoUseCase,
                               ReceberConfirmacaoPagamentoUseCasePort receberConfirmacaoPagamentoUseCase) {

        this.consultarStatusPagamentoUseCase = consultarStatusPagamentoUseCase;
        this.receberConfirmacaoPagamentoUseCase = receberConfirmacaoPagamentoUseCase;
    }

    public PagamentoPresenter consultarStatusPagamento(UUID pedidoId) {
        Boolean pagamentoAprovado = consultarStatusPagamentoUseCase.execute(pedidoId);
        return new PagamentoPresenter(pagamentoAprovado);
    }

    public String receberConfirmacaoPagamento(ComandoDeConfirmacaoDePagamento comandoDeConfirmacaoDePagamento) {
        return receberConfirmacaoPagamentoUseCase.execute(comandoDeConfirmacaoDePagamento);
    }
}
