package br.com.fiap.soat.techChallenge.presenters;

import br.com.fiap.soat.techChallenge.entities.Cliente;

import java.util.UUID;

public class ClientePresenter {

    private UUID id;
    private String nome;
    private String cpf;
    private String telefone;

    public ClientePresenter(UUID id, String nome, String cpf, String telefone) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public static ClientePresenter fromDomain(Cliente cliente) {
        return new ClientePresenter(cliente.getId(), cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
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
