package br.com.fiap.soat.techChallenge.domain.ports.outbound;

import br.com.fiap.soat.techChallenge.entities.Pedido;

import java.util.List;

public interface PedidoRepositoryPort {
    Pedido inserirPedido(Pedido pedido);
    List<Pedido> obterPedidos();
}
