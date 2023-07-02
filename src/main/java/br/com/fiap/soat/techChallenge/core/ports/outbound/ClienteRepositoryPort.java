package br.com.fiap.soat.techChallenge.core.ports.outbound;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

import java.util.Optional;

public interface ClienteRepositoryPort {
    Cliente cadastra(Cliente cliente);
    Optional<Cliente> identificaPor(String cpf);
}
