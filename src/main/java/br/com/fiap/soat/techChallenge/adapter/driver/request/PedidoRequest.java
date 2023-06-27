package br.com.fiap.soat.techChallenge.adapter.driver.request;

import br.com.fiap.soat.techChallenge.core.domain.ItemDoNovoPedido;
import br.com.fiap.soat.techChallenge.core.domain.NovoPedido;

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

    public NovoPedido toDomain() {
        return new NovoPedido(
            this.clienteId,
            this.itens.stream().map(item -> new ItemDoNovoPedido(item.getProdutoId(), item.getQuantidade())).collect(Collectors.toList())
        );
    }
}
