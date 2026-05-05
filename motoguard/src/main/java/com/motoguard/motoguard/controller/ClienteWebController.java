package com.motoguard.motoguard.controller;

import com.motoguard.motoguard.model.Cliente;
import com.motoguard.motoguard.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // Garante a renderização do HTML
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteWebController {

    @Autowired
    private ClienteRepository repo;

    // Rota que carrega a página clientes.html
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("title", "MotoGuard - Clientes");
        model.addAttribute("clientes", repo.findAll()); // Envia a lista para o th:each
        return "clientes";
    }

    // Rota que o formulário chama para salvar
    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Cliente c) {
        repo.save(c);
        return "redirect:/clientes"; // Atualiza a página após salvar
    }

    // Rota para o botão excluir
    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/clientes";
    }
}