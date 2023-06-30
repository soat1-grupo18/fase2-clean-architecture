package br.com.fiap.soat.techChallenge.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemDoPedido {
    private UUID id;
    private String nome;
    private String descricao;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemDoPedido(UUID id, String nome, String descricao, int quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }
}
