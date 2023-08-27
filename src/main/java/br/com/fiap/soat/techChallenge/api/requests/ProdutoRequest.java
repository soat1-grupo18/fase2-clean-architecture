package br.com.fiap.soat.techChallenge.api.requests;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.entities.TipoDeProduto;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ProdutoRequest {
    @NotNull(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo Categoria é obrigatório.")
    private TipoDeProduto categoria;

    @NotNull(message = "O campo Preço é obrigatório.")
    private Float preco;

    private String descricao;
    private String imagem;

    public Produto toDomain(UUID id) {
        return new Produto(id, nome, categoria, preco, descricao, imagem);
    }
    public String getNome() {
        return nome;
    }
    public TipoDeProduto getCategoria() {
        return categoria;
    }
    public Float getPreco() {
        return preco;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getImagem() {
        return imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public void setPreco(Float preco) {
        this.preco = preco;
    }
    public void setCategoria(TipoDeProduto categoria) {
        this.categoria = categoria;
    }
}
