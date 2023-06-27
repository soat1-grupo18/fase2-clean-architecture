package br.com.fiap.soat.techChallenge.core.domain;

import java.util.List;
import java.util.UUID;

public class NovoPedido {
    private UUID clienteId;
    private List<ItemDoNovoPedido> itens;

    public NovoPedido(UUID clienteId, List<ItemDoNovoPedido> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemDoNovoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoNovoPedido> itens) {
        this.itens = itens;
    }
}
