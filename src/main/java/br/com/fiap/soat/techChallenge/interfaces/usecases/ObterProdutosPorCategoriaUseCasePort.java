package br.com.fiap.soat.techChallenge.interfaces.usecases;
import br.com.fiap.soat.techChallenge.entities.Produto;

import java.util.List;

public interface ObterProdutosPorCategoriaUseCasePort {
    List<Produto> execute(Produto.TipoDeProduto categoria);
}
