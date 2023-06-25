package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaClienteAdapterPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.IdentificaClienteUseCasePort;

import java.util.Optional;

public class IdentificaClienteUseCase implements IdentificaClienteUseCasePort {
    private final IdentificaClienteAdapterPort identificaClienteAdapterPort;

    public IdentificaClienteUseCase(IdentificaClienteAdapterPort identificaClienteAdapterPort) {

        this.identificaClienteAdapterPort = identificaClienteAdapterPort;
    }
    @Override
    public Optional<Cliente> execute(String cpf) {
        return identificaClienteAdapterPort.identificaPor(cpf);
    }
}
