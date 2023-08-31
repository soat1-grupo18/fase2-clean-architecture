package br.com.fiap.soat.techChallenge.jpa.entities;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Table(name = "pedidos")
public class PedidoJpaEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private UUID clienteId;
    private BigDecimal preco;
    private StatusDoPedido statusDoPedido;

    private StatusDoPagamento statusDoPagamento;
    private UUID pagamentoId;
    private LocalDateTime dataDeCriacao;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<ItemDoPedidoJpaEntity> itens;

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

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public void setStatusDoPedido(StatusDoPedido statusDoPedido) {
        this.statusDoPedido = statusDoPedido;
    }

    public StatusDoPagamento getStatusDoPagamento() {
        return statusDoPagamento;
    }

    public void setStatusDoPagamento(StatusDoPagamento statusDoPagamento) {
        this.statusDoPagamento = statusDoPagamento;
    }

    public List<ItemDoPedidoJpaEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemDoPedidoJpaEntity> itens) {
        this.itens = itens;
    }

    public Pedido toDomain() {
        return new Pedido(
            id,
            clienteId,
            preco,
            statusDoPedido,
            statusDoPagamento,
            itens.stream().map(ItemDoPedidoJpaEntity::toDomain).collect(Collectors.toList()),
            pagamentoId,
            dataDeCriacao
        );
    }

    public static PedidoJpaEntity fromDomain(Pedido pedido) {
        PedidoJpaEntity pedidoJpaEntity = new PedidoJpaEntity();

        pedidoJpaEntity.setId(pedido.getId());
        pedidoJpaEntity.setClienteId(pedido.getClienteId());
        pedidoJpaEntity.setPreco(pedido.getPreco());
        pedidoJpaEntity.setStatusDoPedido(pedido.getStatusDoPedido());
        pedidoJpaEntity.setStatusDoPagamento(pedido.getStatusDoPagamento());
        pedidoJpaEntity.setPagamentoId(pedido.getPagamentoId());
        pedidoJpaEntity.setItens(pedido.getItens().stream().map(itemDoPedido -> {
            ItemDoPedidoJpaEntity itemDoPedidoJpaEntity = ItemDoPedidoJpaEntity.fromDomain(itemDoPedido);

            itemDoPedidoJpaEntity.setPedido(pedidoJpaEntity);

            return itemDoPedidoJpaEntity;
        }).collect(Collectors.toList()));
        pedidoJpaEntity.setDataDeCriacao(pedido.getDataDeCriacao());

        return pedidoJpaEntity;
    }

    public UUID getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(UUID pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }

    public void setDataDeCriacao(LocalDateTime dataDeCriacao) {
        this.dataDeCriacao = dataDeCriacao;
    }
}
