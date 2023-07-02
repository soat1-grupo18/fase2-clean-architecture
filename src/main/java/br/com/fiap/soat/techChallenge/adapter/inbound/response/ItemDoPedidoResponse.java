package br.com.fiap.soat.techChallenge.adapter.inbound.response;

import br.com.fiap.soat.techChallenge.core.domain.ItemDoPedido;

import java.math.BigDecimal;

public class ItemDoPedidoResponse {
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

    public static ItemDoPedidoResponse fromDomain(ItemDoPedido itemDoPedido) {
        ItemDoPedidoResponse itemDoPedidoResponse = new ItemDoPedidoResponse();

        itemDoPedidoResponse.nome = itemDoPedido.getNome();
        itemDoPedidoResponse.descricao = itemDoPedido.getDescricao();
        itemDoPedidoResponse.categoria = itemDoPedido.getCategoria();
        itemDoPedidoResponse.imagem = itemDoPedido.getImagem();
        itemDoPedidoResponse.quantidade = itemDoPedido.getQuantidade();
        itemDoPedidoResponse.precoUnitario = itemDoPedido.getPrecoUnitario();

        return itemDoPedidoResponse;
    }
}
