package br.com.fiap.soat.techChallenge.adapter.driven.repositories;

import br.com.fiap.soat.techChallenge.adapter.driven.entities.PedidoEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PedidoRepository extends CrudRepository<PedidoEntity, UUID> {
}
