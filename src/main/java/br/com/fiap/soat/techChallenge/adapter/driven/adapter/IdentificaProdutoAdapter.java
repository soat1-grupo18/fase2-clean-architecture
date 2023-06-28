package br.com.fiap.soat.techChallenge.adapter.driven.adapter;

import br.com.fiap.soat.techChallenge.adapter.driven.repositories.ProdutoRepository;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaProdutoAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IdentificaProdutoAdapter implements IdentificaProdutoAdapterPort {

    private final ProdutoRepository produtoRepository;

    public IdentificaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }
    @Override
    public Optional<Produto> identificaPor(String categoria) {
        var produtos = produtoRepository.findByCategoria(categoria);
        if (produtos.isEmpty()) {
            return Optional.empty();
        }
        var produto = produtos.get(0);
        return Optional.of(produto.toDomain());
    }
}
