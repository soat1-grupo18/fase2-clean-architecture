package br.com.fiap.soat.techChallenge.exceptions;

import java.util.UUID;

public class ProdutoNaoEncontradoException extends RuntimeException {
    ProdutoNaoEncontradoException(String message) {
        super(message);
    }

    public static ProdutoNaoEncontradoException aPartirDeProdutoId(UUID id) {
        return new ProdutoNaoEncontradoException(String.format("O produto de ID %s não foi encontrado.", id));
    }
}
