package br.com.fiap.soat.techChallenge.core.usecases;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;

public class CadastrarProdutoUseCase implements CadastrarProdutoUseCasePort {
    private final ProdutoRepositoryPort produtoRepositoryPort;

    public CadastrarProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {
        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public Produto execute(Produto produto) {
        return produtoRepositoryPort.cadastrar(produto);
    }
}
