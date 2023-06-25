package br.com.fiap.soat.techChallenge.adapter.driver;

import br.com.fiap.soat.techChallenge.adapter.driver.request.CadastraClienteRequest;
import br.com.fiap.soat.techChallenge.adapter.driver.response.ClienteResponse;
import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final IdentificaClienteUseCasePort identificaClienteUseCase;
    private final CadastraClienteUseCasePort cadastraClienteUseCase;

    public ClientesController(CadastraClienteUseCasePort cadastraClienteUseCase,
                              IdentificaClienteUseCasePort identificaClienteUseCase) {

        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.identificaClienteUseCase = identificaClienteUseCase;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> identificaCliente(@PathVariable String cpf) {
        Optional<Cliente> clienteO = identificaClienteUseCase.execute(cpf);
        if (clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não identificado.");
        }
        return ResponseEntity.ok(ClienteResponse.fromDomain(clienteO.get()));
    }

    @PostMapping()
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody CadastraClienteRequest cadastraClienteRequest) {
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastraClienteUseCase.execute(cadastraClienteRequest.toDomain())));
    }
}
