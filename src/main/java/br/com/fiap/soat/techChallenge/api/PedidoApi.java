package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.PedidoRequest;
import br.com.fiap.soat.techChallenge.controllers.PedidoController;
import br.com.fiap.soat.techChallenge.presenters.PedidoPresenter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PedidoApi {

    private final PedidoController pedidoController;

    public PedidoApi(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoPresenter> fazerCheckoutPedido(@RequestBody PedidoRequest pedidoRequest) {
        return ResponseEntity.ok(pedidoController.fazerCheckoutPedido(pedidoRequest.toDomain()));
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoPresenter>> obterPedidos() {
        return ResponseEntity.ok(pedidoController.obterPedidos());
    }
}
