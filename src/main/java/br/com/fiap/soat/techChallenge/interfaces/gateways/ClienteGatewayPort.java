package br.com.fiap.soat.techChallenge.interfaces.gateways;

import br.com.fiap.soat.techChallenge.entities.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteGatewayPort {
    Cliente cadastra(Cliente cliente);
    Optional<Cliente> identificaPor(String cpf);
    Optional<Cliente> identificaPorId(UUID id);
}
