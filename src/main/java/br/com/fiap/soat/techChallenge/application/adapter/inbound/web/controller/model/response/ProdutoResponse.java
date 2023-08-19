package br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller.model.response;
import br.com.fiap.soat.techChallenge.entities.Produto;

import java.util.UUID;

public class ProdutoResponse {
    private UUID id;
    private String nome;
    private String descricao;
    private String imagem;
    private Float preco;
    private Produto.TipoDeProduto categoria;

    public ProdutoResponse(UUID id, String nome, String descricao, String imagem, Float preco, Produto.TipoDeProduto categoria) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.imagem = imagem;
        this.preco = preco;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getImagem(), produto.getPreco(), produto.getCategoria());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public Produto.TipoDeProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(Produto.TipoDeProduto categoria) {
        this.categoria = categoria;
    }
}
