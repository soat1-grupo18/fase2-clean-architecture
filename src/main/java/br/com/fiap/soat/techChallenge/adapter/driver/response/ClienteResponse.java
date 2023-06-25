package br.com.fiap.soat.techChallenge.adapter.driver.response;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;

public class ClienteResponse {

    private final String nome;
    private final String cpf;
    private final String telefone;

    public ClienteResponse(String nome, String cpf, String telefone) {

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }
    public static ClienteResponse fromDomain(Cliente cliente) {
        return new ClienteResponse(cliente.getNome(), cliente.getCpf(), cliente.getTelefone());
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }
}
