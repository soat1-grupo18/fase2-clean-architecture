package br.com.fiap.soat.techChallenge.jpa.repositories;

import br.com.fiap.soat.techChallenge.jpa.entities.PedidoJpaEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PedidoRepository extends CrudRepository<PedidoJpaEntity, UUID> {
    List<PedidoJpaEntity> findByPagamentoId(UUID pagamentoId);
}
