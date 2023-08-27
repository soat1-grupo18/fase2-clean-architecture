package br.com.fiap.soat.techChallenge.controllers;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.exceptions.ClienteNaoEncontradoException;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.presenters.ClientePresenter;

public class ClienteController {

    private final CadastrarClienteUseCasePort cadastrarClienteUseCase;
    private final IdentificarClienteUseCasePort identificarClienteUseCase;

    public ClienteController(CadastrarClienteUseCasePort cadastrarClienteUseCase,
                             IdentificarClienteUseCasePort identificarClienteUseCase) {

        this.cadastrarClienteUseCase = cadastrarClienteUseCase;
        this.identificarClienteUseCase = identificarClienteUseCase;
    }

    public ClientePresenter identificarCliente(String cpf) {
        Cliente cliente = identificarClienteUseCase.execute(cpf).orElseThrow(() -> ClienteNaoEncontradoException.aPartirDoCpf(cpf));
        return ClientePresenter.fromDomain(cliente);
    }

    public ClientePresenter cadastrarCliente(Cliente cliente) {
        return ClientePresenter.fromDomain(cadastrarClienteUseCase.execute(cliente));
    }
}
