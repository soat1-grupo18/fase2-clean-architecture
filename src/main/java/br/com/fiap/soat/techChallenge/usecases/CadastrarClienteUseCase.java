package br.com.fiap.soat.techChallenge.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.usecases.CadastrarClienteUseCasePort;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;

public class CadastrarClienteUseCase implements CadastrarClienteUseCasePort {
    private final ClienteGatewayPort clienteGatewayPort;

    public CadastrarClienteUseCase(ClienteGatewayPort clienteGatewayPort) {
        this.clienteGatewayPort = clienteGatewayPort;
    }

    @Override
    public Cliente execute(Cliente cliente) {
        return clienteGatewayPort.cadastra(cliente);
    }
}
