package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.entities.Produto;

public interface EditarProdutoUseCasePort {
    Produto execute(Produto produto);
}
