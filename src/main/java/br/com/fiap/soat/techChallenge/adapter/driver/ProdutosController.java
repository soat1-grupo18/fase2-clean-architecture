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

import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    private final IdentificaProdutoUseCasePort identificaProdutoUseCase;
    private final CadastraProdutoUseCasePort cadastraProdutoUseCase;

    public ProdutosController(CadastraProdutoUseCasePort cadastraProdutoUseCase,
                              IdentificaProdutoUseCasePort identificaProdutoUseCase) {

        this.cadastraProdutoUseCase = cadastraProdutoUseCase;
        this.identificaProdutoUseCase = identificaProdutoUseCase;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Object> identificaProduto(@PathVariable String nome) {
        Optional<Produto> produtoO = identificaProdutoUseCase.execute(nome);
        if (produtoO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não identificado.");
        }
        return ResponseEntity.ok(ProdutoResponse.fromDomain(produtoO.get()));
    }

    @PostMapping("")
    public ResponseEntity<ProdutoResponse> cadastraProduto(@Valid @RequestBody CadastraProdutoRequest cadastraProdutoRequest) {
        return ResponseEntity.ok(ProdutoResponse.fromDomain(cadastraProdutoUseCase.execute(cadastraProdutoRequest.toDomain())));
    }
}
