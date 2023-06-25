package br.com.fiap.soat.techChallenge.adapter.driven.adapter;

import br.com.fiap.soat.techChallenge.adapter.driven.entities.ClienteEntity;
import br.com.fiap.soat.techChallenge.adapter.driven.repositories.ClienteRepository;
import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.driven.CadastraClienteAdapterPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CadastraClienteAdapter implements CadastraClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    public CadastraClienteAdapter(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @Override
    @Transactional
    public Cliente cadastra(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setTelefone(cliente.getTelefone());

        cliente.setId(clienteRepository.save(clienteEntity).getId());

        return cliente;
    }
}
