package br.com.fiap.soat.techChallenge.jpa.repositories;

import br.com.fiap.soat.techChallenge.entities.StatusDoPagamento;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.jpa.entities.PedidoJpaEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends CrudRepository<PedidoJpaEntity, UUID> {
    List<PedidoJpaEntity> findByPagamentoId(UUID pagamentoId);

    @Query("select p from PedidoJpaEntity p " +
            "where p.statusDoPedido IN :statuses " +
            "order by p.dataDeCriacao asc, p.statusDoPedido desc")
    List<PedidoJpaEntity> obterPedidosPorStatus(StatusDoPedido... statuses);
}
