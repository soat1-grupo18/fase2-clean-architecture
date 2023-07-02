package br.com.fiap.soat.techChallenge.core.ports.outbound;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepositoryPort {
    Produto cadastra(Produto produto);
    List<Produto> obterProdutosPor(Produto.TipoDeProduto categoria);
    Optional<Produto> identificaPorId(UUID id);
}
