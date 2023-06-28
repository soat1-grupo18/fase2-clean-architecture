package br.com.fiap.soat.techChallenge.adapter.driven.adapter;
import br.com.fiap.soat.techChallenge.adapter.driven.repositories.ProdutoRepository;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaProdutoAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class IdentificaProdutoAdapter implements IdentificaProdutoAdapterPort {
    private final ProdutoRepository produtoRepository;

    public IdentificaProdutoAdapter(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public List<Produto> identificaPor(String categoria) {
        var produtos = produtoRepository.findByCategoria(categoria);
        if (produtos.isEmpty()) {
            return Collections.emptyList();
        }

        return produtos.stream()
                .map(Produto::toDomain)
                .collect(Collectors.toList());
    }
}
