package br.com.fiap.soat.techChallenge.core.usecases;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.IdentificaProdutoUseCasePort;

import java.util.List;

public class IdentificaProdutoUseCase implements IdentificaProdutoUseCasePort {
    private final ProdutoRepositoryPort produtoRepositoryPort;

    public IdentificaProdutoUseCase(ProdutoRepositoryPort produtoRepositoryPort) {

        this.produtoRepositoryPort = produtoRepositoryPort;
    }

    @Override
    public List<Produto> execute(Produto.TipoDeProduto categoria) {
        return produtoRepositoryPort.identificaPor(categoria);
    }
}
