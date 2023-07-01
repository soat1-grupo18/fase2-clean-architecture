package br.com.fiap.soat.techChallenge.adapter.driven.adapter;
import br.com.fiap.soat.techChallenge.adapter.driven.entities.ProdutoEntity;
import br.com.fiap.soat.techChallenge.adapter.driven.repositories.ProdutoRepository;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driven.CadastraProdutoAdapterPort;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CadastraProdutoAdapter implements CadastraProdutoAdapterPort {
    private final ProdutoRepository produtoRepository;

    public CadastraProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
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

        produtoRepository.save(produtoEntity);

        produto.setId(produtoEntity.getId());

        return produto;
    }
}