package br.com.fiap.soat.techChallenge.adapter.driven.entities;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private UUID clienteId;
    private BigDecimal preco;
    private StatusDoPedido status;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDoPedidoEntity> itens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public void setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    public List<ItemDoPedidoEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedidoEntity> itens) {
        this.itens = itens;
    }

    public Pedido toDomain() {
        return new Pedido(
            id,
            clienteId,
            preco,
            status,
            itens.stream().map(ItemDoPedidoEntity::toDomain).collect(Collectors.toList())
        );
    }

    public static PedidoEntity fromDomain(Pedido pedido) {
        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setId(pedido.getId());
        pedidoEntity.setClienteId(pedido.getClienteId());
        pedidoEntity.setPreco(pedido.getPreco());
        pedidoEntity.setStatus(pedido.getStatus());
        pedidoEntity.setItens(pedido.getItens().stream().map(itemDoPedido -> {
            ItemDoPedidoEntity itemDoPedidoEntity = ItemDoPedidoEntity.fromDomain(itemDoPedido);

            itemDoPedidoEntity.setPedido(pedidoEntity);

            return itemDoPedidoEntity;
        }).collect(Collectors.toList()));

        return pedidoEntity;
    }
}
