package br.com.fiap.soat.techChallenge.interfaces.usecases;

import br.com.fiap.soat.techChallenge.entities.Cliente;

public interface CadastrarClienteUseCasePort {
    Cliente execute(Cliente cliente);
}
