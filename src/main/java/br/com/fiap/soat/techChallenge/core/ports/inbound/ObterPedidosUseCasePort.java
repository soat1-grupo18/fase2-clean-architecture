package br.com.fiap.soat.techChallenge.core.ports.inbound;

import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.usecases.models.ComandoDeNovoPedido;

import java.util.List;

public interface ObterPedidosUseCasePort {
    List<Pedido> execute();
}
