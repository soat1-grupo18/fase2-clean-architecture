package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.ConfirmacaoPagamentoRequest;
import br.com.fiap.soat.techChallenge.controllers.PagamentoController;
import br.com.fiap.soat.techChallenge.presenters.PagamentoPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PagamentoApi {

    private final PagamentoController pagamentoController;

    public PagamentoApi(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }

    @GetMapping("/pagamentos/{pedidoId}")
    public ResponseEntity<PagamentoPresenter> consultarStatusPagamento(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(this.pagamentoController.consultarStatusPagamento(pedidoId));
    }

    @PostMapping("/pagamentos")
    public ResponseEntity<String> receberConfirmacaoPagamento(@RequestBody ConfirmacaoPagamentoRequest confirmacaoPagamentoRequest) {
        return ResponseEntity.ok(this.pagamentoController.receberConfirmacaoPagamento(confirmacaoPagamentoRequest.toDomain()));
    }
}
