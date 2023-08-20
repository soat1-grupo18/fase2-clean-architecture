package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.ProdutoRequest;
import br.com.fiap.soat.techChallenge.controllers.ProdutoController;
import br.com.fiap.soat.techChallenge.entities.Produto;
import br.com.fiap.soat.techChallenge.responses.ProdutoResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoApi {

    private final ProdutoController produtoController;

    public ProdutoApi(ProdutoController produtoController) {

        this.produtoController = produtoController;
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> obterProdutosPorCategoria(@PathVariable Produto.TipoDeProduto categoria) {
        return ResponseEntity.ok(produtoController.obterProdutosPorCategoria(categoria));
    }

    @PostMapping("")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(produtoController.cadastrarProduto(produtoRequest.toDomain(null)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editarProduto(
            @PathVariable(value="id") UUID id,
            @Valid @RequestBody ProdutoRequest produtoRequest
    ) {
        return ResponseEntity.ok(produtoController.editarProduto(produtoRequest.toDomain(id)));
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable(value="id") UUID id) {
        produtoController.excluirProduto(id);
    }
}
