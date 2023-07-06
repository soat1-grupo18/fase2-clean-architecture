package br.com.fiap.soat.techChallenge.core.ports.outbound;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepositoryPort {
    Cliente cadastra(Cliente cliente);
    Optional<Cliente> identificaPor(String cpf);
    Optional<Cliente> identificaPorId(UUID id);
}
