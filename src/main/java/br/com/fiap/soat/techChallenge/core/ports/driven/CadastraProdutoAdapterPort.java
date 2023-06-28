package br.com.fiap.soat.techChallenge.core.ports.driven;

import br.com.fiap.soat.techChallenge.core.domain.Produto;

public interface CadastraProdutoAdapterPort {
    Produto cadastra(Produto produto);
}
