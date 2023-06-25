package br.com.fiap.soat.techChallenge.adapter.driver;

import br.com.fiap.soat.techChallenge.adapter.driver.request.CadastraClienteRequest;
import br.com.fiap.soat.techChallenge.adapter.driver.response.ClienteResponse;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientesController {

    private final CadastraClienteUseCasePort cadastraClienteUseCase;
    private final IdentificaClienteUseCasePort identificaClienteUseCase;

    public ClientesController(CadastraClienteUseCasePort cadastraClienteUseCase,
                              IdentificaClienteUseCasePort identificaClienteUseCase) {

        this.cadastraClienteUseCase = cadastraClienteUseCase;
        this.identificaClienteUseCase = identificaClienteUseCase;
    }

    @PostMapping()
    public ResponseEntity<ClienteResponse> cadastraCliente(@Valid @RequestBody CadastraClienteRequest cadastraClienteRequest) {
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastraClienteUseCase.execute(cadastraClienteRequest.toDomain())));
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> identificaCliente(@PathVariable String cpf) {
        // TODO tratar retorno quando cpf não for encontrado
        return ResponseEntity.ok(ClienteResponse.fromDomain(identificaClienteUseCase.execute(cpf)));
    }

}
