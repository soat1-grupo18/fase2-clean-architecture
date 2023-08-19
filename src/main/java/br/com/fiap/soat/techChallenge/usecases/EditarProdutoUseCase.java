package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ProdutoRepositoryPort;

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
