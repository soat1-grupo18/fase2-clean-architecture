package br.com.fiap.soat.techChallenge.adapter.driven.repositories;

import br.com.fiap.soat.techChallenge.adapter.driven.entities.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteRepository extends JpaRepository<ClienteEntity, UUID> {
    List<ClienteEntity> findByCpf(String cpf);
}
