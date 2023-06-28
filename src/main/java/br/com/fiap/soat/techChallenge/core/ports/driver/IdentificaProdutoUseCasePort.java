package br.com.fiap.soat.techChallenge.core.ports.driver;

import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.Optional;

public interface IdentificaProdutoUseCasePort {
    Optional<Produto> execute(String categoria);
}
