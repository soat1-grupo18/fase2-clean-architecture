package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.ObterProdutosPorCategoriaUseCasePort;
import br.com.fiap.soat.techChallenge.responses.ProdutoResponse;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProdutoController {

    private final ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase;
    private final CadastrarProdutoUseCasePort cadastrarProdutoUseCase;
    private final EditarProdutoUseCasePort editarProdutoUseCase;

    private final ExcluirProdutoUseCasePort excluirProdutoUseCase;

    public ProdutoController(CadastrarProdutoUseCasePort cadastrarProdutoUseCase,
                      EditarProdutoUseCasePort editarProdutoUseCase,
                      ExcluirProdutoUseCasePort excluirProdutoUseCase,
                      ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.editarProdutoUseCase = editarProdutoUseCase;
        this.excluirProdutoUseCase = excluirProdutoUseCase;
        this.obterProdutosPorCategoriaUseCase = obterProdutosPorCategoriaUseCase;
    }

    public List<ProdutoResponse> obterProdutosPorCategoria(Produto.TipoDeProduto categoria) {
        List<Produto> produtos = obterProdutosPorCategoriaUseCase.execute(categoria);
        return produtos.stream().map(ProdutoResponse::fromDomain).collect(Collectors.toList());
    }

    public ProdutoResponse cadastrarProduto(Produto produto) {
        return ProdutoResponse.fromDomain(cadastrarProdutoUseCase.execute(produto));
    }

    public ProdutoResponse editarProduto(Produto produto) {
        return ProdutoResponse.fromDomain(editarProdutoUseCase.execute(produto));
    }

    public void excluirProduto(UUID id) {
        excluirProdutoUseCase.execute(id);
    }
}
