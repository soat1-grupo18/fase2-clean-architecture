package br.com.fiap.soat.techChallenge.jpa.repositories;
import br.com.fiap.soat.techChallenge.entities.TipoDeProduto;
import br.com.fiap.soat.techChallenge.jpa.entities.ProdutoJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<ProdutoJpaEntity, UUID> {
    List<ProdutoJpaEntity> findByCategoria(TipoDeProduto categoria);
}
