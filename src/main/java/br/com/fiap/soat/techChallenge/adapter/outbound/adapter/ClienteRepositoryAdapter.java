package br.com.fiap.soat.techChallenge.adapter.outbound.adapter;

import br.com.fiap.soat.techChallenge.adapter.outbound.entities.ClienteEntity;
import br.com.fiap.soat.techChallenge.adapter.outbound.repositories.ClienteJpaRepository;
import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.outbound.ClienteRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJpaRepository clienteJpaRepository;

    public ClienteRepositoryAdapter(ClienteJpaRepository clienteJpaRepository) {
        this.clienteJpaRepository = clienteJpaRepository;
    }

    @Override
    @Transactional
    public Cliente cadastra(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setTelefone(cliente.getTelefone());

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
}
