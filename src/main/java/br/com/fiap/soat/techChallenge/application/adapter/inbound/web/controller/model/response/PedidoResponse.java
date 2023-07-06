package br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller.model.response;

import br.com.fiap.soat.techChallenge.domain.entity.Pedido;
import br.com.fiap.soat.techChallenge.domain.entity.StatusDoPedido;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoResponse {
    private UUID id;
    private BigDecimal preco;
    private StatusDoPedido status;
    private List<ItemDoPedidoResponse> itens;

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public List<ItemDoPedidoResponse> getItens() {
        return itens;
    }

    public static PedidoResponse fromDomain(Pedido pedido) {
        PedidoResponse pedidoResponse = new PedidoResponse();

        pedidoResponse.id = pedido.getId();
        pedidoResponse.preco = pedido.getPreco();
        pedidoResponse.status = pedido.getStatus();
        pedidoResponse.itens = pedido.getItens().stream().map(ItemDoPedidoResponse::fromDomain).collect(Collectors.toList());

        return pedidoResponse;
    }
}
