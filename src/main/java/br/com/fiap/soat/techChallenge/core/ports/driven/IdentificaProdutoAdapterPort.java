package br.com.fiap.soat.techChallenge.core.ports.driven;

import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.Optional;

public interface IdentificaProdutoAdapterPort {
    Optional<Produto> identificaPor(String nome);
}
