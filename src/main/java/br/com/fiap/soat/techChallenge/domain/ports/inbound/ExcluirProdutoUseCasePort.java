package br.com.fiap.soat.techChallenge.domain.ports.inbound;

import java.util.UUID;

public interface ExcluirProdutoUseCasePort {
    void execute(UUID id);
}
