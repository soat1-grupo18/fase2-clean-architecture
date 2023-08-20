package br.com.fiap.soat.techChallenge.api;

import br.com.fiap.soat.techChallenge.responses.ClienteResponse;
import br.com.fiap.soat.techChallenge.api.requests.CadastrarClienteRequest;
import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteApi {

    private final IdentificarClienteUseCasePort identificarClienteUseCase;
    private final CadastrarClienteUseCasePort cadastrarClienteUseCase;

    public ClienteApi(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                      IdentificarClienteUseCasePort identificarClienteUseCase) {

        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.identificarClienteUseCase = identificarClienteUseCase;
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<ClienteResponse> identificarCliente(@PathVariable String cpf) {
        Cliente cliente = identificarClienteUseCase.execute(cpf).orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoCpf(cpf));

        return ResponseEntity.ok(ClienteResponse.fromDomain(cliente));
    }

    @PostMapping("")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastrarClienteUseCase.execute(cadastrarClienteRequest.toDomain())));
    }
}
