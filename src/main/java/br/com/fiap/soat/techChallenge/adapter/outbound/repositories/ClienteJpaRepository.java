package br.com.fiap.soat.techChallenge.adapter.outbound.repositories;

import br.com.fiap.soat.techChallenge.adapter.outbound.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity, UUID> {
    List<ClienteEntity> findByCpf(String cpf);
}
