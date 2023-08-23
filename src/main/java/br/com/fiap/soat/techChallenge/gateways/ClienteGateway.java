package br.com.fiap.soat.techChallenge.gateways;

import br.com.fiap.soat.techChallenge.jpa.entities.ClienteJpaEntity;
import br.com.fiap.soat.techChallenge.jpa.repositories.ClienteRepository;
import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteGatewayPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteGateway implements ClienteGatewayPort {

    private final ClienteRepository clienteRepository;

    public ClienteGateway(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente cadastra(Cliente cliente) {
        var clienteEntity = ClienteJpaEntity.fromDomain(cliente);
        cliente.setId(clienteRepository.save(clienteEntity).getId());
        return cliente;
    }

    @Override
    public Optional<Cliente> identificaPor(String cpf) {
        var clientes = clienteRepository.findByCpf(cpf);
        if (clientes.isEmpty()) {
            return Optional.empty();
        }
        var cliente = clientes.get(0);
        return Optional.of(cliente.toDomain());
    }

    @Override
    public Optional<Cliente> identificaPorId(UUID id) {
        return clienteRepository.findById(id).map(cliente -> cliente.toDomain());
    }
}
