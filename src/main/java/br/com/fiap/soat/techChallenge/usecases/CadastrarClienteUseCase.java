package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteRepositoryPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public CadastrarClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteRepositoryPort.cadastra(cliente);
    }
}
