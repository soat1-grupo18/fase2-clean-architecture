package br.com.fiap.soat.techChallenge.core.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class PedidoProcessado {
    private UUID id;
    private BigDecimal valor;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
}
