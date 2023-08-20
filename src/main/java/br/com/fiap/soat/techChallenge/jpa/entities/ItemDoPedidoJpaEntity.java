package br.com.fiap.soat.techChallenge.jpa.entities;

import br.com.fiap.soat.techChallenge.entities.ItemDoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "itens_do_pedido")
public class ItemDoPedidoJpaEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String descricao;
    private String categoria;
    private String imagem;
    private int quantidade;
    private BigDecimal precoUnitario;
    @ManyToOne
    private PedidoJpaEntity pedido;

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

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public PedidoJpaEntity getPedido() {
        return pedido;
    }

    public void setPedido(PedidoJpaEntity pedido) {
        this.pedido = pedido;
    }

    public ItemDoPedido toDomain() {
        return new ItemDoPedido(
            id,
            nome,
            descricao,
            categoria,
            imagem,
            quantidade,
            precoUnitario
        );
    }

    public static ItemDoPedidoJpaEntity fromDomain(ItemDoPedido itemDoPedido) {
        ItemDoPedidoJpaEntity itemEntity = new ItemDoPedidoJpaEntity();

        itemEntity.setId(itemDoPedido.getId());
        itemEntity.setNome(itemDoPedido.getNome());
        itemEntity.setDescricao(itemDoPedido.getDescricao());
        itemEntity.setCategoria(itemDoPedido.getCategoria());
        itemEntity.setImagem(itemDoPedido.getImagem());
        itemEntity.setQuantidade(itemDoPedido.getQuantidade());
        itemEntity.setPrecoUnitario(itemDoPedido.getPrecoUnitario());

        return itemEntity;
    }
}
