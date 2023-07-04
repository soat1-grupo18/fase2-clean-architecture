package br.com.fiap.soat.techChallenge.adapter.outbound.adapter;
import br.com.fiap.soat.techChallenge.adapter.outbound.entities.ProdutoEntity;
import br.com.fiap.soat.techChallenge.adapter.outbound.entities.mappers.ProdutoMapper;
import br.com.fiap.soat.techChallenge.adapter.outbound.repositories.ProdutoJpaRepository;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ProdutoRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ProdutoRepositoryAdapter implements ProdutoRepositoryPort {
    private final ProdutoJpaRepository produtoJpaRepository;

    public ProdutoRepositoryAdapter(ProdutoJpaRepository produtoJpaRepository) {
        this.produtoJpaRepository = produtoJpaRepository;
    }

    @Override
    @Transactional
    public Produto cadastrar(Produto produto) {
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);

        produtoJpaRepository.save(produtoEntity);

        produto.setId(produtoEntity.getId());

        return produto;
    }

    @Override
    public List<Produto> obterProdutosPor(Produto.TipoDeProduto categoria) {
        var produtos = produtoJpaRepository.findByCategoria(categoria);
        if (produtos.isEmpty()) {
            return Collections.emptyList();
        }

        return produtos.stream()
                .map(ProdutoMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> identificarPorId(UUID id) {
        return produtoJpaRepository.findById(id).map(ProdutoMapper::toDomain);
    }

    @Override
    public Optional<Produto> editar(Produto produto) {
        var produtoO = produtoJpaRepository.findById(produto.getId());
        if (produtoO.isEmpty()) {
            return Optional.empty();
        }
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        produtoJpaRepository.save(produtoEntity);
        return Optional.of(produto);
    }
}
