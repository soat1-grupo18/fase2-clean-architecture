package br.com.fiap.soat.techChallenge.adapter.driven.adapter;

import br.com.fiap.soat.techChallenge.adapter.driven.repositories.ClienteRepository;
import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import br.com.fiap.soat.techChallenge.core.ports.driven.IdentificaClienteAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class IdentificaClienteAdapter implements IdentificaClienteAdapterPort {

    private final ClienteRepository clienteRepository;

    public IdentificaClienteAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
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
}
