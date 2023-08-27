package br.com.fiap.soat.techChallenge.interfaces.gateways;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.entities.TipoDeProduto;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProdutoGatewayPort {
    Produto cadastrar(Produto produto);
    List<Produto> obterProdutosPor(TipoDeProduto categoria);
    Optional<Produto> identificarPorId(UUID id);

    Produto editar(Produto produto);

    void excluir(UUID id);
}
