package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.IdentificarClienteUseCasePort;

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
