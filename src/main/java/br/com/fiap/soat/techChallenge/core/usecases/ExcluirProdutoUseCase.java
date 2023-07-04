package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.ports.inbound.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;

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
