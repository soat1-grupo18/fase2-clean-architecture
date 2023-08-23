package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;
import br.com.fiap.soat.techChallenge.interfaces.usecases.IdentificarClienteUseCasePort;

import java.util.Optional;

public class IdentificarClienteUseCase implements IdentificarClienteUseCasePort {
    private final ClienteGatewayPort clienteGatewayPort;

    public IdentificarClienteUseCase(ClienteGatewayPort clienteGatewayPort) {

        this.clienteGatewayPort = clienteGatewayPort;
    }
    @Override
    public Optional<Cliente> execute(String cpf) {
        return clienteGatewayPort.identificaPor(cpf);
    }
}
