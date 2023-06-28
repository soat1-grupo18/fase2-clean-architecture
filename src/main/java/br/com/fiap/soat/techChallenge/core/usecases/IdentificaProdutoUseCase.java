package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaProdutoAdapterPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaProdutoUseCasePort;

import java.util.Optional;

public class IdentificaProdutoUseCase implements IdentificaProdutoUseCasePort {
    private final IdentificaProdutoAdapterPort identificaProdutoAdapterPort;

    public IdentificaProdutoUseCase(IdentificaProdutoAdapterPort identificaProdutoAdapterPort) {

        this.identificaProdutoAdapterPort = identificaProdutoAdapterPort;
    }
    @Override
    public Optional<Produto> execute(String categoria) {
        return identificaProdutoAdapterPort.identificaPor(categoria);
    }
}
