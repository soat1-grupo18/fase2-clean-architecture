package br.com.fiap.soat.techChallenge.adapter.outbound.adapter;
import br.com.fiap.soat.techChallenge.adapter.outbound.entities.ProdutoEntity;
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
    public Produto cadastra (Produto produto) {
        ProdutoEntity produtoEntity = new ProdutoEntity();

        produtoEntity.setNome(produto.getNome());
        produtoEntity.setCategoria(produto.getCategoria());
        produtoEntity.setPreço(produto.getPreço());
        produtoEntity.setDescrição(produto.getDescrição());
        produtoEntity.setImagem(produto.getImagem());

        produtoJpaRepository.save(produtoEntity);

        produto.setId(produtoEntity.getId());

        return produto;
    }

    @Override
    public List<Produto> identificaPor(Produto.TipoDeProduto categoria) {
        var produtos = produtoJpaRepository.findByCategoria(categoria);
        if (produtos.isEmpty()) {
            return Collections.emptyList();
        }

        return produtos.stream()
                .map(Produto::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Produto> identificaPorId(UUID id) {
        return produtoJpaRepository.findById(id).map(Produto::toDomain);
    }
}
