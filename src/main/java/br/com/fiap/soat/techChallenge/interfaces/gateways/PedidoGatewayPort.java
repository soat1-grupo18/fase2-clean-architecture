package br.com.fiap.soat.techChallenge.interfaces.gateways;

import br.com.fiap.soat.techChallenge.entities.Pedido;

import java.util.List;

public interface PedidoGatewayPort {
    Pedido inserirPedido(Pedido pedido);
    List<Pedido> obterPedidos();
}
