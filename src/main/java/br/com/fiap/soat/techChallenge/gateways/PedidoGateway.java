package br.com.fiap.soat.techChallenge.gateways;

import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.exceptions.PedidoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.jpa.entities.PedidoJpaEntity;
import br.com.fiap.soat.techChallenge.jpa.repositories.PedidoRepository;
import br.com.fiap.soat.techChallenge.entities.Pedido;
import br.com.fiap.soat.techChallenge.interfaces.gateways.PedidoGatewayPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class PedidoGateway implements PedidoGatewayPort {
    public PedidoGateway(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    private final PedidoRepository pedidoRepository;

    @Override
    @Transactional
    public Pedido inserirPedido(Pedido pedido) {
        PedidoJpaEntity pedidoJpaEntity = PedidoJpaEntity.fromDomain(pedido);

        pedidoRepository.save(pedidoJpaEntity);

        return pedidoJpaEntity.toDomain();
    }

    @Override
    public Pedido obterPedido(UUID pedidoId) {
        var pedidoO = pedidoRepository.findById(pedidoId);
        if (pedidoO.isEmpty()) {
            throw PedidoNaoEncontradoException.aPartirDoId(pedidoId);
        }
        return pedidoO.get().toDomain();
    }

    @Override
    public List<Pedido> obterTodosPedidos() {
        return StreamSupport.stream(pedidoRepository.findAll().spliterator(), false)
                .map(PedidoJpaEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Boolean consultarStatusPagamento(UUID pedidoId) {
        var pedido = obterPedido(pedidoId);
        return pedido.isPagamentoAprovado();
    }

    @Override
    public void atualizarPedido(Pedido pedido) {
        PedidoJpaEntity pedidoJpaEntity = PedidoJpaEntity.fromDomain(pedido);
        pedidoRepository.save(pedidoJpaEntity);
    }

    @Override
    public Optional<Pedido> obterPedidoComPagamentoId(UUID pagamentoId) {
        var pedidoO = pedidoRepository.findByPagamentoId(pagamentoId);
        return Optional.ofNullable(pedidoO.get(0).toDomain());
    }

    @Override
    public List<Pedido> obterPedidosPorStatus(StatusDoPedido... statuses) {
        return pedidoRepository.obterPedidosPorStatus(statuses).stream()
                .map(PedidoJpaEntity::toDomain).collect(Collectors.toList());
    }
}
