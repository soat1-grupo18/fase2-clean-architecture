package br.com.fiap.soat.techChallenge.core.ports.outbound;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoRepositoryPort {
    Produto cadastrar(Produto produto);
    List<Produto> obterProdutosPor(Produto.TipoDeProduto categoria);
    Optional<Produto> identificarPorId(UUID id);

    Produto editar(Produto produto);

    void excluir(UUID id);
}
