package br.com.fiap.soat.techChallenge.core.ports.inbound;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

public interface CadastrarProdutoUseCasePort {
    Produto execute(Produto produto);
}
