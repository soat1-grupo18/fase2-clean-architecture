package br.com.fiap.soat.techChallenge.core.ports.inbound;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.List;

public interface IdentificaProdutoUseCasePort {
    List<Produto> execute(Produto.TipoDeProduto categoria);
}
