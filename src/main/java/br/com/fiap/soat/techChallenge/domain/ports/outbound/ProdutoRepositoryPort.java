package br.com.fiap.soat.techChallenge.domain.ports.outbound;
import br.com.fiap.soat.techChallenge.entities.Produto;

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
