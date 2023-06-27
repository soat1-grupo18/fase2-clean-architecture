package br.com.fiap.soat.techChallenge.core.ports.driver;

import br.com.fiap.soat.techChallenge.core.domain.NovoPedido;
import br.com.fiap.soat.techChallenge.core.domain.PedidoProcessado;

public interface FazerPedidoUseCasePort {
    PedidoProcessado execute(NovoPedido novoPedido);
}
