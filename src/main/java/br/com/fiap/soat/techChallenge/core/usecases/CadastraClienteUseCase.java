package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.inbound.CadastraClienteUseCasePort;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;

public class CadastraClienteUseCase implements CadastraClienteUseCasePort {
    private final ClienteRepositoryPort clienteRepositoryPort;

    public CadastraClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteRepositoryPort.cadastra(cliente);
    }
}
