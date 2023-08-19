package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.interfaces.usecases.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoRepositoryPort;

import java.util.UUID;

public class ExcluirProdutoUseCase implements ExcluirProdutoUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public ExcluirProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {

        this.produtoRepositoryPort = produtoRepositoryPort;
    }
    @Override
    public void execute(UUID id) {
        produtoRepositoryPort.excluir(id);
    }
}
