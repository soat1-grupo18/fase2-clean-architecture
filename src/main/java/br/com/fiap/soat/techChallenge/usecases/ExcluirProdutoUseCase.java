package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.interfaces.usecases.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoGatewayPort;

import java.util.UUID;

public class ExcluirProdutoUseCase implements ExcluirProdutoUseCasePort {

    private final ProdutoGatewayPort produtoGatewayPort;

    public ExcluirProdutoUseCase(ProdutoGatewayPort produtoGatewayPort) {

        this.produtoGatewayPort = produtoGatewayPort;
    }
    @Override
    public void execute(UUID id) {
        produtoGatewayPort.excluir(id);
    }
}
