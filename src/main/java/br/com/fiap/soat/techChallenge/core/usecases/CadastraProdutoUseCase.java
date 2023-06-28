package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driven.CadastraProdutoAdapterPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraProdutoUseCasePort;

public class CadastraProdutoUseCase implements CadastraProdutoUseCasePort {
    private final CadastraProdutoAdapterPort cadastraProdutoAdapterPort;

    public CadastraProdutoUseCase(CadastraProdutoAdapterPort cadastraProdutoAdapterPort) {
        this.cadastraProdutoAdapterPort = cadastraProdutoAdapterPort;
    }

    @Override
    public Produto execute(Produto produto) {
        return cadastraProdutoAdapterPort.cadastra(produto);
    }
}
