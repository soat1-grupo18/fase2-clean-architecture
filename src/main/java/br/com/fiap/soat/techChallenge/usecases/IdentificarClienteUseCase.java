package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;

import java.util.Optional;

public class IdentificarClienteUseCase implements IdentificarClienteUseCasePort {
    private final ClienteRepositoryPort identificaClienteAdapterPort;

    public IdentificarClienteUseCase(ClienteRepositoryPort identificaClienteAdapterPort) {

        this.identificaClienteAdapterPort = identificaClienteAdapterPort;
    }
    @Override
    public Optional<Cliente> execute(String cpf) {
        return identificaClienteAdapterPort.identificaPor(cpf);
    }
}
