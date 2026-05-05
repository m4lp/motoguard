package com.motoguard.motoguard.model;

import jakarta.persistence.*;

@Entity
public class Moto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String placa;
    private String cor;
    private Integer ano;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente; // Relacionamento com a classe Cliente[cite: 2]

    // Getters essenciais para renderizar a página motos.html[cite: 2]
    public Long getId() { return id; }
    public String getModelo() { return modelo; }
    public String getPlaca() { return placa; }
    public String getCor() { return cor; }
    public Integer getAno() { return ano; }
    public Cliente getCliente() { return cliente; }

    // Setters para o formulário de cadastro de motos[cite: 2]
    public void setId(Long id) { this.id = id; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public void setPlaca(String placa) { this.placa = placa; }
    public void setCor(String cor) { this.cor = cor; }
    public void setAno(Integer ano) { this.ano = ano; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}