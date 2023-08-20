package br.com.fiap.soat.techChallenge.gateways.jpa.entity;

import br.com.fiap.soat.techChallenge.entities.Cliente;
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

    public static ClienteEntity fromDomain (Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setNome(cliente.getNome());
        clienteEntity.setCpf(cliente.getCpf());
        clienteEntity.setTelefone(cliente.getTelefone());

        return clienteEntity;
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
