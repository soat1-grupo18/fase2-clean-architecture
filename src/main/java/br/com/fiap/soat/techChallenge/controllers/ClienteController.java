package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.responses.ClienteResponse;

public class ClienteController {

    private final CadastrarClienteUseCasePort cadastrarClienteUseCase;
    private final IdentificarClienteUseCasePort identificarClienteUseCase;

    public ClienteController(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                             IdentificarClienteUseCasePort identificarClienteUseCase) {

        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.identificarClienteUseCase = identificarClienteUseCase;
    }

    public ClienteResponse identificarCliente(String cpf) {
        Cliente cliente = identificarClienteUseCase.execute(cpf).orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoCpf(cpf));
        return ClienteResponse.fromDomain(cliente);
    }

    public ClienteResponse cadastrarCliente(Cliente cliente) {
        return ClienteResponse.fromDomain(cadastrarClienteUseCase.execute(cliente));
    }
}
