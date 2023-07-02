package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;
import br.com.fiap.soat.techChallenge.core.ports.inbound.IdentificaClienteUseCasePort;

import java.util.Optional;

public class IdentificaClienteUseCase implements IdentificaClienteUseCasePort {
    private final ClienteRepositoryPort identificaClienteAdapterPort;

    public IdentificaClienteUseCase(ClienteRepositoryPort identificaClienteAdapterPort) {

        this.identificaClienteAdapterPort = identificaClienteAdapterPort;
    }
    @Override
    public Optional<Cliente> execute(String cpf) {
        return identificaClienteAdapterPort.identificaPor(cpf);
    }
}
