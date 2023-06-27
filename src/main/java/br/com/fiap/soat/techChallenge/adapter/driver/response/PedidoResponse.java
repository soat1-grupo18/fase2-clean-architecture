package br.com.fiap.soat.techChallenge.adapter.driver.response;

import java.util.UUID;

public class PedidoResponse {
    private UUID id;

    public PedidoResponse(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
