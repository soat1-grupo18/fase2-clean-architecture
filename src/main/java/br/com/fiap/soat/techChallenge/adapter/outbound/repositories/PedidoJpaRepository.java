package br.com.fiap.soat.techChallenge.adapter.outbound.repositories;

import br.com.fiap.soat.techChallenge.adapter.outbound.entities.PedidoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PedidoJpaRepository extends CrudRepository<PedidoEntity, UUID> {
}
