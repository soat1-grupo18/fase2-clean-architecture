package br.com.fiap.soat.techChallenge.exceptions;

import java.util.UUID;

public class ClienteNaoEncontradoException extends RuntimeException {
    ClienteNaoEncontradoException(String message) {
        super(message);
    }

    public static ClienteNaoEncontradoException aPartirDoCpf(String cpf) {
        return new ClienteNaoEncontradoException(String.format("O cliente de CPF %s não foi encontrado.", cpf));
    }

    public static ClienteNaoEncontradoException aPartirDoId(UUID id) {
        return new ClienteNaoEncontradoException(String.format("O cliente de ID %s não foi encontrado.", id));
    }
}
