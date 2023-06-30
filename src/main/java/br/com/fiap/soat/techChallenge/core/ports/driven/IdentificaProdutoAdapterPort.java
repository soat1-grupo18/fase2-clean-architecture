package br.com.fiap.soat.techChallenge.core.ports.driven;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.List;

public interface IdentificaProdutoAdapterPort {
    List<Produto> identificaPor(String categoria);
}
