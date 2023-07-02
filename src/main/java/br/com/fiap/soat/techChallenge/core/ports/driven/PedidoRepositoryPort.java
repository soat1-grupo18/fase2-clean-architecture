package br.com.fiap.soat.techChallenge.core.ports.driven;

import br.com.fiap.soat.techChallenge.core.domain.Pedido;

public interface PedidoRepositoryPort {
    Pedido inserirPedido(Pedido pedido);
}
