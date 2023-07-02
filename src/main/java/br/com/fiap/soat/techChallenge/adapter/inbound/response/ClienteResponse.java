package br.com.fiap.soat.techChallenge.adapter.inbound.response;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

import java.util.UUID;

public class ClienteResponse {

    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;

    public ClienteResponse(UUID id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public static ClienteResponse fromDomain(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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
