package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;

import java.util.Optional;

public class EditarProdutoUseCase implements EditarProdutoUseCasePort {

    private final ProdutoRepositoryPort produtoRepositoryPort;

    public EditarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }
    @Override
    public Produto execute(Produto produto) {
        return produtoRepositoryPort.editar(produto);
    }
}
