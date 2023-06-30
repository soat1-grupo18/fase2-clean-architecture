package br.com.fiap.soat.techChallenge.adapter.driven.entities;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.domain.StatusDoPedido;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "pedidos")
public class PedidoEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;
    private BigDecimal preco;
    private StatusDoPedido status;
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<ItemDoPedidoEntity> itens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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


}
