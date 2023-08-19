package br.com.fiap.soat.techChallenge.domain.ports.inbound;

import br.com.fiap.soat.techChallenge.domain.usecases.model.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.entities.Pedido;

public interface FazerPedidoUseCasePort {
    Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido);
}
