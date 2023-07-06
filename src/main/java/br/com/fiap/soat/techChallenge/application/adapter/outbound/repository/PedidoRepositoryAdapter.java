package br.com.fiap.soat.techChallenge.application.adapter.outbound.repository;

import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.entity.PedidoEntity;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.PedidoJpaRepository;
import br.com.fiap.soat.techChallenge.domain.entity.Pedido;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.PedidoRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PedidoRepositoryAdapter implements PedidoRepositoryPort {
    public PedidoRepositoryAdapter(PedidoJpaRepository pedidoJpaRepository) {
        this.pedidoJpaRepository = pedidoJpaRepository;
    }

    private PedidoJpaRepository pedidoJpaRepository;

    @Override
    @Transactional
    public Pedido inserirPedido(Pedido pedido) {
        PedidoEntity pedidoEntity = PedidoEntity.fromDomain(pedido);

        pedidoJpaRepository.save(pedidoEntity);

        return pedidoEntity.toDomain();
    }

    @Override
    public List<Pedido> obterPedidos() {
        return StreamSupport.stream(pedidoJpaRepository.findAll().spliterator(), false).map(PedidoEntity::toDomain).collect(Collectors.toList());
    }
}
