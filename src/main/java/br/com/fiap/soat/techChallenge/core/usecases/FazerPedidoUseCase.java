package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.NovoPedido;
import br.com.fiap.soat.techChallenge.core.domain.PedidoProcessado;
import br.com.fiap.soat.techChallenge.core.ports.driver.FazerPedidoUseCasePort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class FazerPedidoUseCase implements FazerPedidoUseCasePort {

    @Override
    public PedidoProcessado execute(NovoPedido novoPedido) {
        PedidoProcessado pedidoProcessado = new PedidoProcessado();

        // TODO: fazer integração com produtos

        pedidoProcessado.setId(UUID.randomUUID());
        pedidoProcessado.setValor(new BigDecimal("25.00"));

        return pedidoProcessado;
    }
}
