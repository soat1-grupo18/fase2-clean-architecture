package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.controllers.PagamentoController;
import br.com.fiap.soat.techChallenge.responses.PagamentoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/pagamento")
public class PagamentoApi {

    private final PagamentoController pagamentoController;

    public PagamentoApi(PagamentoController pagamentoController) {
        this.pagamentoController = pagamentoController;
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<PagamentoResponse> consultarStatusPagamento(@PathVariable UUID pedidoId) {
        return ResponseEntity.ok(this.pagamentoController.consultarStatusPagamento(pedidoId));
    }
}
