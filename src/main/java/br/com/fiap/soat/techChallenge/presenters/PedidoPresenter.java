package br.com.fiap.soat.techChallenge.presenters;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class PedidoPresenter {
    private UUID id;
    private BigDecimal preco;
    private StatusDoPedido statusDoPedido;
    private StatusDoPagamento statusDoPagamento;
    private List<ItemDoPedidoPresenter> itens;
    private UUID pagamentoId;
    private LocalDateTime dataDeCriacao;

    public UUID getId() {
        return id;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public StatusDoPedido getStatusDoPedido() {
        return statusDoPedido;
    }

    public StatusDoPagamento getStatusDoPagamento() {
        return statusDoPagamento;
    }

    public List<ItemDoPedidoPresenter> getItens() {
        return itens;
    }

    public static PedidoPresenter fromDomain(Pedido pedido) {
        PedidoPresenter pedidoPresenter = new PedidoPresenter();

        pedidoPresenter.id = pedido.getId();
        pedidoPresenter.preco = pedido.getPreco();
        pedidoPresenter.statusDoPedido = pedido.getStatusDoPedido();
        pedidoPresenter.statusDoPagamento = pedido.getStatusDoPagamento();
        pedidoPresenter.itens = pedido.getItens().stream().map(ItemDoPedidoPresenter::fromDomain).collect(Collectors.toList());
        pedidoPresenter.pagamentoId = pedido.getPagamentoId();
        pedidoPresenter.dataDeCriacao = pedido.getDataDeCriacao();

        return pedidoPresenter;
    }

    public UUID getPagamentoId() {
        return pagamentoId;
    }

    public LocalDateTime getDataDeCriacao() {
        return dataDeCriacao;
    }
}
