package br.com.fiap.soat.techChallenge.adapter.driven.entities;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "produtos")
public class ProdutoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private UUID id;
    private String nome;
    private Produto.TipoDeProduto categoria;
    private Float preço;
    private String descrição;
    private String imagem;

    public Produto toDomain() {
        return new Produto(id, nome, categoria, preço, descrição, imagem);
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Produto.TipoDeProduto getCategoria() {
        return categoria;
    }

    public String getDescrição() {
        return descrição;
    }

    public Float getPreço() {
        return preço;
    }

    public String getImagem() {
        return imagem;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCategoria(Produto.TipoDeProduto categoria) {
        this.categoria = categoria;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public void setPreço(Float preço) {
        this.preço = preço;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
