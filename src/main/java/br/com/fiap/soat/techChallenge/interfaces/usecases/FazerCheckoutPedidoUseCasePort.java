package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.usecases.model.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.entities.Pedido;

public interface FazerCheckoutPedidoUseCasePort {
    Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido);
}
