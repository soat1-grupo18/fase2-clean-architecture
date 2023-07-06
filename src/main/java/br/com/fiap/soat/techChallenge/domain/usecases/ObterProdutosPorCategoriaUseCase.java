package br.com.fiap.soat.techChallenge.domain.usecases;
import br.com.fiap.soat.techChallenge.domain.entity.Produto;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.ObterProdutosPorCategoriaUseCasePort;

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
