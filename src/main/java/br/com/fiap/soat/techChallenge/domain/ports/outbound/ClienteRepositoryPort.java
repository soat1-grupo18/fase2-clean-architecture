package br.com.fiap.soat.techChallenge.domain.ports.outbound;

import br.com.fiap.soat.techChallenge.domain.entity.Cliente;

import java.util.Optional;
import java.util.UUID;

public interface ClienteRepositoryPort {
    Cliente cadastra(Cliente cliente);
    Optional<Cliente> identificaPor(String cpf);
    Optional<Cliente> identificaPorId(UUID id);
}
