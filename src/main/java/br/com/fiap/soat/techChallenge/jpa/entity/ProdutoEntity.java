package br.com.fiap.soat.techChallenge.jpa.entity;
import br.com.fiap.soat.techChallenge.entities.Produto;
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
    private Float preco;
    private String descricao;
    private String imagem;

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Produto.TipoDeProduto getCategoria() {
        return categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public Float getPreco() {
        return preco;
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
