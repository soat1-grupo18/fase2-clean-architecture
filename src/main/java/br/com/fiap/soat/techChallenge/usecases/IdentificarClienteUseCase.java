package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;

import java.util.Optional;

public class IdentificarClienteUseCase implements IdentificarClienteUseCasePort {
    private final ClienteGatewayPort clienteGateway;

    public IdentificarClienteUseCase(ClienteGatewayPort clienteGateway) {

        this.clienteGateway = clienteGateway;
    }
    @Override
    public Optional<Cliente> execute(String cpf) {
        return clienteGateway.identificaPor(cpf);
    }
}
