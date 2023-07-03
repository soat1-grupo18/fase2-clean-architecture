package br.com.fiap.soat.techChallenge.adapter.inbound;

import br.com.fiap.soat.techChallenge.adapter.inbound.request.CadastrarClienteRequest;
import br.com.fiap.soat.techChallenge.adapter.inbound.response.ClienteResponse;
import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.IdentificarClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final IdentificarClienteUseCasePort identificarClienteUseCase;
    private final CadastrarClienteUseCasePort cadastrarClienteUseCase;

    public ClienteController(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                             IdentificarClienteUseCasePort identificarClienteUseCase) {

        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.identificarClienteUseCase = identificarClienteUseCase;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<Object> identificarCliente(@PathVariable String cpf) {
        Optional<Cliente> clienteO = identificarClienteUseCase.execute(cpf);
        if (clienteO.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não identificado.");
        }
        return ResponseEntity.ok(ClienteResponse.fromDomain(clienteO.get()));
    }

    @PostMapping("")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastrarClienteUseCase.execute(cadastrarClienteRequest.toDomain())));
    }
}
