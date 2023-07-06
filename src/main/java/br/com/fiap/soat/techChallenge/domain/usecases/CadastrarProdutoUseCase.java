package br.com.fiap.soat.techChallenge.domain.usecases;
import br.com.fiap.soat.techChallenge.domain.entity.Produto;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ProdutoRepositoryPort;

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
