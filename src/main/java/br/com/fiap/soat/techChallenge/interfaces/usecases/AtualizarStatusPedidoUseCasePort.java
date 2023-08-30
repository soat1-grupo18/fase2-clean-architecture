package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;

import java.util.UUID;

public interface AtualizarStatusPedidoUseCasePort {

    Pedido execute(UUID pedidoId, StatusDoPedido statusDoPedido);
}
