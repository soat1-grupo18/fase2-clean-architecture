package br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller;

import br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller.model.response.ClienteResponse;
import br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller.model.request.CadastrarClienteRequest;
import br.com.fiap.soat.techChallenge.domain.entity.Cliente;
import br.com.fiap.soat.techChallenge.domain.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.IdentificarClienteUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<ClienteResponse> identificarCliente(@PathVariable String cpf) {
        Cliente cliente = identificarClienteUseCase.execute(cpf).orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoCpf(cpf));

        return ResponseEntity.ok(ClienteResponse.fromDomain(cliente));
    }

    @PostMapping("")
    public ResponseEntity<ClienteResponse> cadastrarCliente(@Valid @RequestBody CadastrarClienteRequest cadastrarClienteRequest) {
        return ResponseEntity.ok(ClienteResponse.fromDomain(cadastrarClienteUseCase.execute(cadastrarClienteRequest.toDomain())));
    }
}
