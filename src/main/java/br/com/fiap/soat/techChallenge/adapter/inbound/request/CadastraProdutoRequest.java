package br.com.fiap.soat.techChallenge.adapter.inbound.request;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import jakarta.validation.constraints.NotNull;

public class CadastraProdutoRequest {
    @NotNull(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo Categoria é obrigatório.")
    private Produto.TipoDeProduto categoria;

    @NotNull(message = "O campo Preço é obrigatório.")
    private Float preço;

    private String descrição;
    private String imagem;

    public Produto toDomain() {
        return new Produto(null, nome, categoria, preço, descrição, imagem);
    }
    public String getNome() {
        return nome;
    }
    public Produto.TipoDeProduto getCategoria() {
        return categoria;
    }
    public Float getPreço() {
        return preço;
    }
    public String getDescrição() {
        return descrição;
    }
    public String getImagem() {
        return imagem;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    public void setPreço(Float preço) {
        this.preço = preço;
    }
    public void setCategoria(Produto.TipoDeProduto categoria) {
        this.categoria = categoria;
    }
}
