package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.ProdutoRequest;
import br.com.fiap.soat.techChallenge.controllers.ProdutoController;
import br.com.fiap.soat.techChallenge.entities.TipoDeProduto;
import br.com.fiap.soat.techChallenge.presenters.ProdutoPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "API de Produtos")
public class ProdutoApi {

    private final ProdutoController produtoController;

    public ProdutoApi(ProdutoController produtoController) {

        this.produtoController = produtoController;
    }

    @Operation(summary = "Obter produtos por categoria", description = "Retorna uma lista de produtos filtrada pelo tipo de produto informado.")
    @GetMapping("/produtos/{categoria}")
    public ResponseEntity<List<ProdutoPresenter>> obterProdutosPorCategoria(@PathVariable TipoDeProduto categoria) {
        return ResponseEntity.ok(produtoController.obterProdutosPorCategoria(categoria));
    }

    @Operation(summary = "Cadastrar produto", description = "Cadastra um novo produto com os dados informados.")
    @PostMapping("/produtos")
    public ResponseEntity<ProdutoPresenter> cadastrarProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(produtoController.cadastrarProduto(produtoRequest.toDomain(null)));
    }

    @Operation(summary = "Editar produto", description = "Atualiza um produto identificado pelo id com os dados informados.")
    @PutMapping("/produtos/{id}")
    public ResponseEntity<ProdutoPresenter> editarProduto(
            @PathVariable(value="id") UUID id,
            @Valid @RequestBody ProdutoRequest produtoRequest
    ) {
        return ResponseEntity.ok(produtoController.editarProduto(produtoRequest.toDomain(id)));
    }

    @Operation(summary = "Excluir produto", description = "Exclui um produto das opções para pedido.")
    @DeleteMapping("/produtos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluirProduto(@PathVariable(value="id") UUID id) {
        produtoController.excluirProduto(id);
    }
}
