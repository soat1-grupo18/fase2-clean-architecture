package br.com.fiap.soat.techChallenge.core.ports.inbound;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

import java.util.Optional;

public interface IdentificaClienteUseCasePort {
    Optional<Cliente> execute(String cpf);
}
