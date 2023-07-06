package br.com.fiap.soat.techChallenge.domain.usecases;

import br.com.fiap.soat.techChallenge.domain.entity.Cliente;
import br.com.fiap.soat.techChallenge.domain.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.domain.ports.inbound.IdentificarClienteUseCasePort;

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
