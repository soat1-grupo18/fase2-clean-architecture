package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.entities.Pedido;

import java.util.Optional;
import java.util.UUID;

public interface ConsultarStatusPagamentoUseCasePort {
    Boolean execute(UUID pedidoId);
}
