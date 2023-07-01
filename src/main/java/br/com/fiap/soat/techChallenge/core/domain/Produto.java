package br.com.fiap.soat.techChallenge.core.domain;
import br.com.fiap.soat.techChallenge.adapter.driven.entities.ProdutoEntity;

import java.util.UUID;

public class Produto {
    public static Produto toDomain(ProdutoEntity produtoEntity) {
        UUID id = produtoEntity.getId();
        String nome = produtoEntity.getNome();
        TipoDeProduto categoria = produtoEntity.getCategoria();
        Float preço = produtoEntity.getPreço();
        String descrição = produtoEntity.getDescrição();
        String imagem = produtoEntity.getImagem();

        Produto produto = new Produto(id, nome, categoria, preço, descrição, imagem);

        return produto;
    }

    public enum TipoDeProduto {
        LANCHE,
        ACOMPANHAMENTO,
        BEBIDA,
        SOBREMESA
    }

    private UUID id;
    private String nome;
    private TipoDeProduto categoria;
    private Float preço;
    private String descrição;
    private String imagem;

    public Produto(UUID id, String nome, TipoDeProduto categoria, Float preço, String descrição, String imagem) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preço = preço;
        this.descrição = descrição;
        this.imagem = imagem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPreço(Float preço) {
        this.preço = preço;
    }

    public void setCategoria(TipoDeProduto categoria) { this.categoria = categoria; }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Float getPreço() {
        return preço;
    }

    public TipoDeProduto getCategoria() {
        return categoria;
    }

    public String getDescrição() {
        return descrição;
    }

    public String getImagem() {
        return imagem;
    }
}