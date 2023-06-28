package br.com.fiap.soat.techChallenge.adapter.driver;
import br.com.fiap.soat.techChallenge.adapter.driver.request.CadastraProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.driver.response.ProdutoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaProdutoUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final IdentificaProdutoUseCasePort identificaProdutoUseCase;
    private final CadastraProdutoUseCasePort cadastraProdutoUseCase;

    public ProdutosController(CadastraProdutoUseCasePort cadastraProdutoUseCase, IdentificaProdutoUseCasePort identificaProdutoUseCase) {
        this.cadastraProdutoUseCase = cadastraProdutoUseCase;
        this.identificaProdutoUseCase = identificaProdutoUseCase;
    }

    @GetMapping("/{categoria}")
    public ResponseEntity<Object> identificaProduto(@PathVariable String categoria) {
        List<Produto> produtos = identificaProdutoUseCase.execute(categoria);

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
