package br.com.fiap.soat.techChallenge.domain.ports.inbound;

import br.com.fiap.soat.techChallenge.domain.entity.Cliente;

import java.util.Optional;

public interface IdentificarClienteUseCasePort {
    Optional<Cliente> execute(String cpf);
}
