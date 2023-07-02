package br.com.fiap.soat.techChallenge.core.usecases;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastraProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;

public class CadastraProdutoUseCase implements CadastraProdutoUseCasePort {
    private final ProdutoRepositoryPort produtoRepositoryPort;

    public CadastraProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto execute(Produto produto) {
        return produtoRepositoryPort.cadastra(produto);
    }
}
