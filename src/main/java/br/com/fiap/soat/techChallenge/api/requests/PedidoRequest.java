package br.com.fiap.soat.techChallenge.api.requests;

import br.com.fiap.soat.techChallenge.usecases.model.ItemDoComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoRequest {
    private UUID clienteId;
    private List<ItemDoPedidoRequest> itens;

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemDoPedidoRequest> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedidoRequest> itens) {
        this.itens = itens;
    }

    public ComandoDeNovoPedido toDomain() {
        return new ComandoDeNovoPedido(
            this.clienteId,
            this.itens.stream().map(item -> new ItemDoComandoDeNovoPedido(item.getProdutoId(), item.getQuantidade())).collect(Collectors.toList())
        );
    }
}
