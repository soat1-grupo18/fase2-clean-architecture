package br.com.fiap.soat.techChallenge.adapter.driver.response;

import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;

import java.math.BigDecimal;
import java.util.UUID;

public class PedidoResponse {
    private UUID id;
    private BigDecimal preco;
    private StatusDoPedido status;

    public PedidoResponse(UUID id, BigDecimal preco, StatusDoPedido status) {
        this.id = id;
        this.preco = preco;
        this.status = status;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public StatusDoPedido getStatus() {
        return status;
    }
}
