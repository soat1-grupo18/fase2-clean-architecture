package br.com.fiap.soat.techChallenge.core.ports.driver;

import br.com.fiap.soat.techChallenge.core.usecases.models.ComandoDeNovoPedido;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;

public interface FazerPedidoUseCasePort {
    Pedido execute(ComandoDeNovoPedido comandoDeNovoPedido);
}