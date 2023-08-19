package br.com.fiap.soat.techChallenge.usecases.model;

import java.util.List;
import java.util.UUID;

public class ComandoDeNovoPedido {
    private UUID clienteId;
    private List<ItemDoComandoDeNovoPedido> itens;

    public ComandoDeNovoPedido(UUID clienteId, List<ItemDoComandoDeNovoPedido> itens) {
        this.clienteId = clienteId;
        this.itens = itens;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemDoComandoDeNovoPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoComandoDeNovoPedido> itens) {
        this.itens = itens;
    }
}
