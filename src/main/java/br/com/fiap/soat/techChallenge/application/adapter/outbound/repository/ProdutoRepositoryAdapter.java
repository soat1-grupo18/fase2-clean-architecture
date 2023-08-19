package br.com.fiap.soat.techChallenge.application.adapter.outbound.repository;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.entity.ProdutoEntity;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.ProdutoJpaRepository;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.entity.mappers.ProdutoMapper;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ProdutoRepositoryPort;
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
    public Produto editar(Produto produto) {
        var produtoO = produtoJpaRepository.findById(produto.getId());
        if (produtoO.isEmpty()) {
            throw ProdutoNaoEncontradoException.aPartirDeProdutoId(produto.getId());
        }
        ProdutoEntity produtoEntity = ProdutoMapper.toEntity(produto);
        produtoJpaRepository.save(produtoEntity);
        return produto;
    }

    @Override
    public void excluir(UUID id) {
        var produtoO = produtoJpaRepository.findById(id);
        if (produtoO.isEmpty()) {
            throw ProdutoNaoEncontradoException.aPartirDeProdutoId(id);
        }
        produtoJpaRepository.deleteById(id);
    }
}
