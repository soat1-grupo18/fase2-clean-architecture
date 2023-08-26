package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {
    private final ClienteGatewayPort clienteGateway;

    public CadastrarClienteUseCase(ClienteGatewayPort clienteGateway) {
        this.clienteGateway = clienteGateway;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteGateway.cadastra(cliente);
    }
}
