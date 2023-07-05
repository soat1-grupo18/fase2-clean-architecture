package br.com.fiap.soat.techChallenge.core.ports.outbound;

import br.com.fiap.soat.techChallenge.core.domain.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
    Pedido inserirPedido(Pedido pedido);
    List<Pedido> obterPedidos();
}
