package com.motoguard.motoguard.controller;

import com.motoguard.motoguard.model.Cliente;
import com.motoguard.motoguard.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes") // Endpoint da API para o "grupo de proteção" ou testes
public class ClientController {

    @Autowired
    private ClienteRepository repo;

    // Retorna a lista completa incluindo os novos campos (Email, Cidade, etc)
    @GetMapping
    public List<Cliente> listar() {
        return repo.findAll();
    }

    // Salva o cliente com todos os novos atributos enviados via JSON
    @PostMapping
    public Cliente salvar(@RequestBody Cliente c) {
        return repo.save(c);
    }

    // Busca um cliente específico pelo ID
    @GetMapping("/{id}")
    public Cliente buscar(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}