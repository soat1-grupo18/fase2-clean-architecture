package br.com.fiap.soat.techChallenge.core.ports.driven;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

public interface CadastraClienteAdapterPort {
    Cliente cadastra(Cliente cliente);
}
