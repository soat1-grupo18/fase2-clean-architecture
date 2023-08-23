package br.com.fiap.soat.techChallenge.api.requests;

import java.util.UUID;

public class ItemDoPedidoRequest {
    private UUID produtoId;
    private int quantidade;

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
