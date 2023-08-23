package br.com.fiap.soat.techChallenge.jpa.repositories;

import br.com.fiap.soat.techChallenge.jpa.entities.ClienteJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteJpaEntity, UUID> {
    List<ClienteJpaEntity> findByCpf(String cpf);
}
