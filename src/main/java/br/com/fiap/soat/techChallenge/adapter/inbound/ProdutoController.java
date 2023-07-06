package br.com.fiap.soat.techChallenge.adapter.inbound;

import br.com.fiap.soat.techChallenge.adapter.inbound.request.ProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.ProdutoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ExcluirProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterProdutosPorCategoriaUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
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

    @GetMapping("/{categoria}")
    public ResponseEntity<List<ProdutoResponse>> obterProdutosPorCategoria(@PathVariable Produto.TipoDeProduto categoria) {
        List<Produto> produtos = obterProdutosPorCategoriaUseCase.execute(categoria);

        return ResponseEntity.ok(produtos.stream().map(ProdutoResponse::fromDomain).collect(Collectors.toList()));
    }

    @PostMapping("")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody ProdutoRequest produtoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(cadastrarProdutoUseCase.execute(produtoRequest.toDomain(null))));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> editarProduto(
            @PathVariable(value="id") UUID id,
            @Valid @RequestBody ProdutoRequest produtoRequest
    ) {
        var produto = editarProdutoUseCase.execute(produtoRequest.toDomain(id));

        return ResponseEntity.ok(ProdutoResponse.fromDomain(produto));
    }

    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable(value="id") UUID id) {
        excluirProdutoUseCase.execute(id);
    }
}
