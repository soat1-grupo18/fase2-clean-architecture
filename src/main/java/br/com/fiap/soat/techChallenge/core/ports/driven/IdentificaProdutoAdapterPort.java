package br.com.fiap.soat.techChallenge.core.ports.driven;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IdentificaProdutoAdapterPort {
    List<Produto> identificaPor(Produto.TipoDeProduto categoria);
    Optional<Produto> identificaPorId(UUID id);
}
