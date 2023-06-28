package br.com.fiap.soat.techChallenge.adapter.driven.repositories;
import br.com.fiap.soat.techChallenge.adapter.driven.entities.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, UUID> {
    List<ProdutoEntity> findByCategoria(String categoria);
}
