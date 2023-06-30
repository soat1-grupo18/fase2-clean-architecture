package br.com.fiap.soat.techChallenge.core.ports.driver;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

public interface CadastraProdutoUseCasePort {
    Produto execute(Produto produto);
}
