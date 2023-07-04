package br.com.fiap.soat.techChallenge.adapter.inbound;
import br.com.fiap.soat.techChallenge.adapter.inbound.request.CadastrarProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.request.EditarProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.ProdutoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterProdutosPorCategoriaUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase;
    private final CadastrarProdutoUseCasePort cadastrarProdutoUseCase;
    private final EditarProdutoUseCasePort editarProdutoUseCase;

    public ProdutoController(CadastrarProdutoUseCasePort cadastrarProdutoUseCase,
                             EditarProdutoUseCasePort editarProdutoUseCase,
                             ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase) {
        this.cadastrarProdutoUseCase = cadastrarProdutoUseCase;
        this.editarProdutoUseCase = editarProdutoUseCase;
        this.obterProdutosPorCategoriaUseCase = obterProdutosPorCategoriaUseCase;
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<Object> obterProdutosPorCategoria(@PathVariable Produto.TipoDeProduto categoria) {
        List<Produto> produtos = obterProdutosPorCategoriaUseCase.execute(categoria);

        if (produtos.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foram encontrados produtos nessa categoria.");
        }

        return ResponseEntity.ok(produtos.stream().map(ProdutoResponse::fromDomain).collect(Collectors.toList()));
    }

    @PostMapping("")
    public ResponseEntity<ProdutoResponse> cadastrarProduto(@Valid @RequestBody CadastrarProdutoRequest cadastrarProdutoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(cadastrarProdutoUseCase.execute(cadastrarProdutoRequest.toDomain())));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> editarProduto(@PathVariable(value="id") UUID id,
                                                @Valid @RequestBody EditarProdutoRequest editarProdutoRequest) {

        Optional<Produto> produtoO = editarProdutoUseCase.execute(editarProdutoRequest.toDomain());
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoO.get()));
    }
}
