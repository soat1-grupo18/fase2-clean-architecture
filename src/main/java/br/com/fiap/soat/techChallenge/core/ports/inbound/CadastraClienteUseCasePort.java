package br.com.fiap.soat.techChallenge.core.ports.inbound;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

public interface CadastraClienteUseCasePort {
    Cliente execute(Cliente cliente);
}