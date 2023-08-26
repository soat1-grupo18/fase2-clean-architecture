package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.interfaces.usecases.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;

import java.util.UUID;

public class ExcluirProdutoUseCase implements ExcluirProdutoUseCasePort {

    private final ProdutoGatewayPort produtoGateway;

    public ExcluirProdutoUseCase(ProdutoGatewayPort produtoGateway) {

        this.produtoGateway = produtoGateway;
    }
    @Override
    public void execute(UUID id) {
        produtoGateway.excluir(id);
    }
}
