package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;

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
