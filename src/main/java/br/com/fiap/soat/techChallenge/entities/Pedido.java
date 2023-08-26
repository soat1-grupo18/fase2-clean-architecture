package br.com.fiap.soat.techChallenge.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido {
    private UUID id;
    private UUID clienteId;
    private BigDecimal preco;
    private StatusDoPedido statusDoPedido;
    private StatusDoPagamento statusDoPagamento;
    private List<ItemDoPedido> itens;

    public Pedido(UUID id,
                  UUID clienteId,
                  BigDecimal preco,
                  StatusDoPedido statusDoPedido,
                  StatusDoPagamento statusDoPagamento,
                  List<ItemDoPedido> itens) {
        this.id = id;
        this.clienteId = clienteId;
        this.preco = preco;
        this.statusDoPedido = statusDoPedido;
        this.statusDoPagamento = statusDoPagamento;
        this.itens = itens;
    }

    public Pedido() {
        this.preco = BigDecimal.ZERO;
        this.itens = new ArrayList<>();
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public void adicionarItem(ItemDoPedido item) {
        this.itens.add(item);
        this.preco = this.preco.add(item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade())));
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }
    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setItens(List<ItemDoPedido> itens) {
        this.itens = itens;
    }
    public List<ItemDoPedido> getItens() {
        return itens;
    }

    public StatusDoPagamento getStatusDoPagamento() {
        return statusDoPagamento;
    }

    public void setStatusDoPagamento(StatusDoPagamento statusDoPagamento) {
        this.statusDoPagamento = statusDoPagamento;
    }

    public boolean isPagamentoAprovado() {
        return this.statusDoPagamento == StatusDoPagamento.APROVADO;
    }
}
