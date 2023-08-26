package br.com.fiap.soat.techChallenge.gateways;

import br.com.fiap.soat.techChallenge.exceptions.PedidoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PagamentoGatewayPort;
import br.com.fiap.soat.techChallenge.jpa.repositories.PedidoRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PagamentoGateway implements PagamentoGatewayPort {

    private final PedidoRepository pedidoRepository;

    public PagamentoGateway(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @Override
    public Boolean consultarStatusPagamento(UUID pedidoId) {
        var pedidoO = pedidoRepository.findById(pedidoId);
        if (pedidoO.isEmpty()) {
            throw PedidoNaoEncontradoException.aPartirDoId(pedidoId);
        }
        var pedido = pedidoO.get().toDomain();
        return pedido.isPagamentoAprovado();
    }
}
