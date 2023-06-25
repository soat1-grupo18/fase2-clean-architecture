package br.com.fiap.soat.techChallenge.core.ports.driver;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

public interface IdentificaClienteUseCasePort {
    Cliente execute(String cpf);
}
