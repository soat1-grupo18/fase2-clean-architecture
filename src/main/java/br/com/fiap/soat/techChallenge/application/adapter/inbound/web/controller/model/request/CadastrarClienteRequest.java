package br.com.fiap.soat.techChallenge.application.adapter.inbound.web.controller.model.request;

import br.com.fiap.soat.techChallenge.domain.entity.Cliente;
import jakarta.validation.constraints.NotNull;

public class CadastrarClienteRequest {

    @NotNull(message = "O campo Nome é obrigatório.")
    private String nome;

    @NotNull(message = "O campo CPF é obrigatório.")
    private String cpf;

    @NotNull(message = "O campo Telefone é obrigatório.")
    private String telefone;

    public Cliente toDomain() {
        return new Cliente(nome, cpf, telefone);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
