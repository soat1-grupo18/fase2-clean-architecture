package br.com.fiap.soat.techChallenge.adapter.driver.response;
import br.com.fiap.soat.techChallenge.core.domain.Produto;

import java.util.UUID;

public class ProdutoResponse {
    private UUID id;
    private String nome;
    private String descrição;
    private String imagem;
    private Float preço;
    private Produto.TipoDeProduto categoria;

    public ProdutoResponse(UUID id, String nome, String descrição, String imagem, Float preço, Produto.TipoDeProduto categoria) {
        this.id = id;
        this.nome = nome;
        this.descrição = descrição;
        this.imagem = imagem;
        this.preço = preço;
        this.categoria = categoria;
    }

    public static ProdutoResponse fromDomain(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescrição(), produto.getImagem(), produto.getPreço(), produto.getCategoria());
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

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Float getPreço() {
        return preço;
    }

    public void setPreço(Float preço) {
        this.preço = preço;
    }

    public Produto.TipoDeProduto getCategoria() {
        return categoria;
    }

    public void setCategoria(Produto.TipoDeProduto categoria) {
        this.categoria = categoria;
    }
}
