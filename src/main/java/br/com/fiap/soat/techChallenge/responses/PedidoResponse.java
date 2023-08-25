package br.com.fiap.soat.techChallenge.responses;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoResponse {
    private UUID id;
    private BigDecimal preco;
    private StatusDoPedido statusDoPedido;
    private StatusDoPagamento statusDoPagamento;
    private List<ItemDoPedidoResponse> itens;

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public StatusDoPagamento getStatusDoPagamento() {
        return statusDoPagamento;
    }

    public List<ItemDoPedidoResponse> getItens() {
        return itens;
    }

    public static PedidoResponse fromDomain(Pedido pedido) {
        PedidoResponse pedidoResponse = new PedidoResponse();

        pedidoResponse.id = pedido.getId();
        pedidoResponse.preco = pedido.getPreco();
        pedidoResponse.statusDoPedido = pedido.getStatusDoPedido();
        pedidoResponse.statusDoPagamento = pedido.getStatusDoPagamento();
        pedidoResponse.itens = pedido.getItens().stream().map(ItemDoPedidoResponse::fromDomain).collect(Collectors.toList());

        return pedidoResponse;
    }
}
