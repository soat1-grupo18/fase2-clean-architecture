package br.com.fiap.soat.techChallenge.application.adapter.outbound.repository;

import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.entity.ClienteEntity;
import br.com.fiap.soat.techChallenge.application.adapter.outbound.repository.jpa.ClienteJpaRepository;
import br.com.fiap.soat.techChallenge.entities.Cliente;
import br.com.fiap.soat.techChallenge.interfaces.gateways.ClienteRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    @Transactional
    public Cliente cadastra(Cliente cliente) {
        var clienteEntity = ClienteEntity.fromDomain(cliente);
        cliente.setId(clienteJpaRepository.save(clienteEntity).getId());
        return cliente;
    }

    @Override
    public Optional<Cliente> identificaPor(String cpf) {
        var clientes = clienteJpaRepository.findByCpf(cpf);
        if (clientes.isEmpty()) {
            return Optional.empty();
        }
        var cliente = clientes.get(0);
        return Optional.of(cliente.toDomain());
    }

    @Override
    public Optional<Cliente> identificaPorId(UUID id) {
        return clienteJpaRepository.findById(id).map(cliente -> cliente.toDomain());
    }
}
