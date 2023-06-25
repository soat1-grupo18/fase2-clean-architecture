package br.com.fiap.soat.techChallenge.core.ports.driven;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

import java.util.Optional;

public interface IdentificaClienteAdapterPort {
    Optional<Cliente> identificaPor(String cpf);
}
