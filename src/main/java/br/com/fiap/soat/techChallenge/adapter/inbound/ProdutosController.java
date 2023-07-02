package br.com.fiap.soat.techChallenge.adapter.inbound;
import br.com.fiap.soat.techChallenge.adapter.inbound.request.CadastraProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.ProdutoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastraProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ObterProdutosPorCategoriaUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase;
    private final CadastraProdutoUseCasePort cadastraProdutoUseCase;

    public ProdutosController(CadastraProdutoUseCasePort cadastraProdutoUseCase, ObterProdutosPorCategoriaUseCasePort obterProdutosPorCategoriaUseCase) {
        this.cadastraProdutoUseCase = cadastraProdutoUseCase;
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
    public ResponseEntity<ProdutoResponse> cadastraProduto(@Valid @RequestBody CadastraProdutoRequest cadastraProdutoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(cadastraProdutoUseCase.execute(cadastraProdutoRequest.toDomain())));
    }
}
