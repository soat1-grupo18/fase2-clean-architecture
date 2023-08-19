package br.com.fiap.soat.techChallenge.usecases;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterProdutosPorCategoriaUseCasePort;

import java.util.List;

public class ObterProdutosPorCategoriaUseCase implements ObterProdutosPorCategoriaUseCasePort {
    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ObterProdutosPorCategoriaUseCase(ProdutoRepositoryPort produtoRepositoryPort) {

        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public List<Produto> execute(Produto.TipoDeProduto categoria) {
        return produtoRepositoryPort.obterProdutosPor(categoria);
    }
}
