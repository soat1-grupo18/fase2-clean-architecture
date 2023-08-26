package br.com.fiap.soat.techChallenge.interfaces.gateways;

import br.com.fiap.soat.techChallenge.entities.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface PagamentoGatewayPort {
    Boolean consultarStatusPagamento(UUID pedidoId);
}
