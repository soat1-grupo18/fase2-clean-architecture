package br.com.fiap.soat.techChallenge.adapter.inbound;
import br.com.fiap.soat.techChallenge.adapter.inbound.request.CadastrarProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.request.EditarProdutoRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.ProdutoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Produto;
import br.com.fiap.soat.techChallenge.core.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.EditarProdutoUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.ExcluirProdutoUseCasePort;
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

        try {
            var produto = editarProdutoUseCase.execute(editarProdutoRequest.toDomain());
            return ResponseEntity.ok(ProdutoResponse.fromDomain(produto));
        } catch (ProdutoNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto(@PathVariable(value="id") UUID id) {
        try {
            excluirProdutoUseCase.execute(id);
            return ResponseEntity.ok("Produto excluído com sucesso.");
        } catch (ProdutoNaoEncontradoException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado.");
        }
    }
}
