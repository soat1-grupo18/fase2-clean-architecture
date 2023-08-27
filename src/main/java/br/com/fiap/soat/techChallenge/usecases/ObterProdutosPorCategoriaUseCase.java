package br.com.fiap.soat.techChallenge.usecases;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.entities.TipoDeProduto;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterProdutosPorCategoriaUseCasePort;

import java.util.List;

public class ObterProdutosPorCategoriaUseCase implements ObterProdutosPorCategoriaUseCasePort {
    private final ProdutoGatewayPort produtoGateway;

    public ObterProdutosPorCategoriaUseCase(ProdutoGatewayPort produtoGateway) {

        this.produtoGateway = produtoGateway;
    }

    @Override
    public List<Produto> execute(TipoDeProduto categoria) {
        return produtoGateway.obterProdutosPor(categoria);
    }
}
