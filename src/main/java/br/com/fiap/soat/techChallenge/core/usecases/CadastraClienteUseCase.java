package br.com.fiap.soat.techChallenge.core.usecases;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.driven.CadastraClienteAdapterPort;
import br.com.fiap.soat.techChallenge.core.ports.driver.CadastraClienteUseCasePort;

public class CadastraClienteUseCase implements CadastraClienteUseCasePort {
    private final CadastraClienteAdapterPort cadastraClienteAdapterPort;

    public CadastraClienteUseCase(CadastraClienteAdapterPort cadastraClienteAdapterPort) {
        this.cadastraClienteAdapterPort = cadastraClienteAdapterPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return cadastraClienteAdapterPort.cadastra(cliente);
    }
}
