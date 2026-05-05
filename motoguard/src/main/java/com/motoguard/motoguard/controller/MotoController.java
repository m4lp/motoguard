package com.motoguard.motoguard.controller;

import com.motoguard.motoguard.model.*;
import com.motoguard.motoguard.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    @Autowired
    private MotoRepository motoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", motoRepo.findAll());
        model.addAttribute("clientes", clienteRepo.findAll()); // Alimenta o select de donos[cite: 7]
        return "motos";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Moto moto, @RequestParam Long clienteId) {
        Cliente cliente = clienteRepo.findById(clienteId).orElseThrow(); // Busca o dono[cite: 7]
        moto.setCliente(cliente); // Vincula a moto ao dono[cite: 7, 2]
        motoRepo.save(moto);
        return "redirect:/motos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        motoRepo.deleteById(id);
        return "redirect:/motos";
    }
}