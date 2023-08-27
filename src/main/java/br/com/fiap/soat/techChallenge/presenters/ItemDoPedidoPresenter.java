package br.com.fiap.soat.techChallenge.presenters;

import br.com.fiap.soat.techChallenge.entities.ItemDoPedido;

import java.math.BigDecimal;

public class ItemDoPedidoPresenter {
    private String nome;
    private String descricao;
    private String categoria;
    private String imagem;
    private int quantidade;
    private BigDecimal precoUnitario;

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getImagem() {
        return imagem;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public static ItemDoPedidoPresenter fromDomain(ItemDoPedido itemDoPedido) {
        ItemDoPedidoPresenter itemDoPedidoPresenter = new ItemDoPedidoPresenter();

        itemDoPedidoPresenter.nome = itemDoPedido.getNome();
        itemDoPedidoPresenter.descricao = itemDoPedido.getDescricao();
        itemDoPedidoPresenter.categoria = itemDoPedido.getCategoria();
        itemDoPedidoPresenter.imagem = itemDoPedido.getImagem();
        itemDoPedidoPresenter.quantidade = itemDoPedido.getQuantidade();
        itemDoPedidoPresenter.precoUnitario = itemDoPedido.getPrecoUnitario();

        return itemDoPedidoPresenter;
    }
}
