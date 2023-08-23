package br.com.fiap.soat.techChallenge.entities;

import java.math.BigDecimal;
import java.util.UUID;

public class ItemDoPedido {
    private UUID id;
    private String nome;
    private String descricao;
    private String categoria;
    private String imagem;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemDoPedido(UUID id, String nome, String descricao, String categoria, String imagem, int quantidade, BigDecimal precoUnitario) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.imagem = imagem;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }
}
