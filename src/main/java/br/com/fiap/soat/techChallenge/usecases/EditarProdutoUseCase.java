package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.interfaces.usecases.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;

public class EditarProdutoUseCase implements EditarProdutoUseCasePort {

    private final ProdutoGatewayPort produtoGatewayPort;

    public EditarProdutoUseCase(ProdutoGatewayPort produtoGatewayPort) {
        this.produtoGatewayPort = produtoGatewayPort;
    }
    @Override
    public Produto execute(Produto produto) {
        return produtoGatewayPort.editar(produto);
    }
}
