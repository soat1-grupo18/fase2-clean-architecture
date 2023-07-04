package br.com.fiap.soat.techChallenge.adapter.outbound.entities.mappers;

import br.com.fiap.soat.techChallenge.adapter.outbound.entities.ProdutoEntity;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

public class ProdutoMapper {

    public static Produto toDomain(ProdutoEntity entity) {
        return new Produto(entity.getId(), entity.getNome(), entity.getCategoria(), entity.getPreco(), entity.getDescricao(), entity.getImagem());
    }

    public static ProdutoEntity toEntity(Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setId(produto.getId());
        produtoEntity.setNome(produto.getNome());
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setPreco(produto.getPreco());
        produtoEntity.setDescricao(produto.getDescricao());
        produtoEntity.setImagem(produto.getImagem());

        return produtoEntity;
    }
}
