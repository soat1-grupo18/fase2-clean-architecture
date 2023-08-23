package br.com.fiap.soat.techChallenge.gateways;

import br.com.fiap.soat.techChallenge.jpa.entities.PedidoJpaEntity;
import br.com.fiap.soat.techChallenge.jpa.repositories.PedidoRepository;
import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PedidoGateway implements PedidoGatewayPort {
    public PedidoGateway(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    private PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public Pedido inserirPedido(Pedido pedido) {
        PedidoJpaEntity pedidoJpaEntity = PedidoJpaEntity.fromDomain(pedido);

        pedidoRepository.save(pedidoJpaEntity);

        return pedidoJpaEntity.toDomain();
    }

    @Override
    public List<Pedido> obterPedidos() {
        return StreamSupport.stream(pedidoRepository.findAll().spliterator(), false).map(PedidoJpaEntity::toDomain).collect(Collectors.toList());
    }
}
