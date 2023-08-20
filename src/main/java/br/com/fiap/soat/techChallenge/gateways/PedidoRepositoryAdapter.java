package br.com.fiap.soat.techChallenge.gateways;

import br.com.fiap.soat.techChallenge.gateways.jpa.entity.PedidoEntity;
import br.com.fiap.soat.techChallenge.gateways.jpa.PedidoJpaRepository;
import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoRepositoryPort;
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
