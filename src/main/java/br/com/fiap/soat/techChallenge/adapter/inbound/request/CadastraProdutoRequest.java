package br.com.fiap.soat.techChallenge.adapter.inbound.request;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import jakarta.validation.constraints.NotNull;

public class CadastraProdutoRequest {
    @NotNull(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo Categoria é obrigatório.")
    private Produto.TipoDeProduto categoria;

    @NotNull(message = "O campo Preço é obrigatório.")
    private Float preco;

    private String descricao;
    private String imagem;

    public Produto toDomain() {
        return new Produto(null, nome, categoria, preco, descricao, imagem);
    }
    public String getNome() {
        return nome;
    }
    public Produto.TipoDeProduto getCategoria() {
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
    public void setCategoria(Produto.TipoDeProduto categoria) {
        this.categoria = categoria;
    }
}
