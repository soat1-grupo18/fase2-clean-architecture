package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.api.requests.PedidoRequest;
import br.com.fiap.soat.techChallenge.controllers.PedidoController;
import br.com.fiap.soat.techChallenge.entities.StatusDoPedido;
import br.com.fiap.soat.techChallenge.presenters.PedidoPresenter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Tag(name = "API de Pedidos")
public class PedidoApi {

    private final PedidoController pedidoController;

    public PedidoApi(PedidoController pedidoController) {
        this.pedidoController = pedidoController;
    }

    @Operation(summary = "Fazer checkout do pedido", description = "Realiza o checkout após a seleção dos produtos do pedido.")
    @PostMapping("/pedidos")
    public ResponseEntity<PedidoPresenter> fazerCheckoutPedido(@RequestBody PedidoRequest pedidoRequest) {
        return ResponseEntity.ok(pedidoController.fazerCheckoutPedido(pedidoRequest.toDomain()));
    }

    @Operation(summary = "Obter pedidos", description = "Retorna uma lista de pedidos, opcionalmente filtrada por status.")
    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoPresenter>> obterPedidos(@RequestParam(name = "status", required = false) StatusDoPedido[] statuses) {
        List<PedidoPresenter> pedidos;

        if (statuses != null && statuses.length > 0) {
            pedidos = pedidoController.obterPedidosPorStatus(statuses);
        } else {
            pedidos = pedidoController.obterTodosPedidos();
        }

        return ResponseEntity.ok(pedidos);
    }

    @Operation(summary = "Atualizar status do pedido", description = "Altera o status de um pedido identificado pelo seu id.")
    @PutMapping("/pedidos/{pedidoId}/{statusDoPedido}")
    public ResponseEntity<PedidoPresenter> atualizarStatusPedido(@PathVariable UUID pedidoId, @PathVariable StatusDoPedido statusDoPedido) {
        return ResponseEntity.ok(pedidoController.atualizarStatusPedido(pedidoId, statusDoPedido));
    }
}

