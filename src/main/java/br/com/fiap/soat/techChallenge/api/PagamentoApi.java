package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.controllers.PagamentoController;
import br.com.fiap.soat.techChallenge.presenters.PagamentoPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/pagamento")
public class PagamentoApi {

    private final PagamentoController pagamentoController;

    public PagamentoApi(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PagamentoPresenter> consultarStatusPagamento(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(this.pagamentoController.consultarStatusPagamento(pedidoId));
    }

    @PostMapping("/")
    public ResponseEntity<String> receberConfirmacaoPagamento() {
        var message = "Pagamento confirmado";
        return ResponseEntity.ok().body(message);
    }
}
