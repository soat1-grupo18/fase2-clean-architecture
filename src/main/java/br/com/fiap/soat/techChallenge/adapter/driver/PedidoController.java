package br.com.fiap.soat.techChallenge.adapter.driver;

import br.com.fiap.soat.techChallenge.adapter.driver.request.PedidoRequest;
import br.com.fiap.soat.techChallenge.adapter.driver.response.PedidoResponse;
import br.com.fiap.soat.techChallenge.core.domain.Pedido;
import br.com.fiap.soat.techChallenge.core.exceptions.ProdutoNaoEncontradoException;
import br.com.fiap.soat.techChallenge.core.ports.driver.FazerPedidoUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

    private final FazerPedidoUseCasePort fazerPedidoUseCasePort;

    public PedidoController(FazerPedidoUseCasePort fazerPedidoUseCasePort) {
        this.fazerPedidoUseCasePort = fazerPedidoUseCasePort;
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoResponse> checkout(@RequestBody PedidoRequest pedidoRequest) {
        try {
            Pedido pedido = fazerPedidoUseCasePort.execute(pedidoRequest.toDomain());

            PedidoResponse response = PedidoResponse.fromDomain(pedido);

            return ResponseEntity.ok(response);
        }
        catch (ProdutoNaoEncontradoException ex) {
            return  ResponseEntity.badRequest().build();
        }
    }
}
