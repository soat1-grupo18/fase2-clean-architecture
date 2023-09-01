package br.com.fiap.soat.techChallenge.interfaces.gateways;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PedidoGatewayPort {
    Pedido inserirPedido(Pedido pedido);

    Pedido obterPedido(UUID pedidoId);

    List<Pedido> obterTodosPedidos();

    Boolean consultarStatusPagamento(UUID pedidoId);

    void atualizarPedido(Pedido pedido);

    Optional<Pedido> obterPedidoComPagamentoId(UUID pagamentoId);

    List<Pedido> obterPedidosPorStatus(StatusDoPedido... statuses);
}
