package com.motoguard.motoguard.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Import correto do Jakarta
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Nome obrigatório")
    private String nome;

    @NotBlank(message = "CPF obrigatório")
    @Column(unique = true)
    private String cpf;

    private String telefone; //[cite: 1]
    private String email; //[cite: 1]

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Moto> motos; //[cite: 1]

    public Cliente() {}

    // Getters e Setters corrigidos para o Thymeleaf não dar Erro 500
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String t) { this.telefone = t; }
    public String getEmail() { return email; }
    public void setEmail(String e) { this.email = e; }
    public List<Moto> getMotos() { return motos; }
    public void setMotos(List<Moto> m) { this.motos = m; }
}