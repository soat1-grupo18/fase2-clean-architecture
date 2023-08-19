package br.com.fiap.soat.techChallenge.usecases.model;

import java.util.UUID;

public class ItemDoComandoDeNovoPedido {
    private UUID produtoId;
    private int quantidade;

    public ItemDoComandoDeNovoPedido(UUID produtoId, int quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public UUID getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(UUID produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
