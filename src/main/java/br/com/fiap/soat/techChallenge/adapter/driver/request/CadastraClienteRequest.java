package br.com.fiap.soat.techChallenge.adapter.driver.request;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import jakarta.validation.constraints.NotNull;

public class CadastraClienteRequest {

    @NotNull(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo CPF é obrigatório.")
    private String cpf;

    @NotNull(message = "O campo Telefone é obrigatório.")
    private String telefone;

    public Cliente toDomain() {
        return new Cliente(nome, cpf, telefone);
    }
}
