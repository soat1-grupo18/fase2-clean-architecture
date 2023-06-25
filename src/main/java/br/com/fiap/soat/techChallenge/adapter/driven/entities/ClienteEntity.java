package br.com.fiap.soat.techChallenge.adapter.driven.entities;

import br.com.fiap.soat.techChallenge.core.domain.Cliente;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "clientes")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private UUID id;

    private String nome;
    private String cpf;
    private String telefone;

    public Cliente toDomain() {
        return new Cliente(id, nome, cpf, telefone);
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
