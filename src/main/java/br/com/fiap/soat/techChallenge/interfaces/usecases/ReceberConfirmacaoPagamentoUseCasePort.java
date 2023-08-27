package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeConfirmacaoDePagamento;

public interface ReceberConfirmacaoPagamentoUseCasePort {

    String execute(ComandoDeConfirmacaoDePagamento comandoDeConfirmacaoDePagamento);
}
