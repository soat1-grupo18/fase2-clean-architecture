package br.com.fiap.soat.techChallenge.adapter.driven.adapter;

import br.com.fiap.soat.techChallenge.adapter.driven.entities.ItemDoPedidoEntity;
import br.com.fiap.soat.techChallenge.adapter.driven.entities.PedidoEntity;
import br.com.fiap.soat.techChallenge.adapter.driven.repositories.PedidoRepository;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.ports.driven.PedidoRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {
    public PedidoRepositoryAdapter(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public Pedido inserirPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = PedidoEntity.fromDomain(pedido);

        pedidoRepository.save(pedidoEntity);

        return pedidoEntity.toDomain();
    }
}
