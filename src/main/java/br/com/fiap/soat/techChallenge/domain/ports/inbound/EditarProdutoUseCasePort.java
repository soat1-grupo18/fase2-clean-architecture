package br.com.fiap.soat.techChallenge.domain.ports.inbound;

import br.com.fiap.soat.techChallenge.domain.entity.Produto;

public interface EditarProdutoUseCasePort {
    Produto execute(Produto produto);
}
