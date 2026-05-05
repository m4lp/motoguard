package com.motoguard.motoguard.controller;

import com.motoguard.motoguard.repository.ClienteRepository;
import com.motoguard.motoguard.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RelatorioController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private MotoRepository motoRepository;

    @GetMapping("/relatorio")
    public String relatorio(Model model) {
        long totalClientes = clienteRepository.count();
        long totalMotos = motoRepository.count();

        model.addAttribute("title", "MotoGuard - Relatorio");
        model.addAttribute("totalClientes", totalClientes);
        model.addAttribute("totalMotos", totalMotos);
        model.addAttribute("mediaMotosPorCliente", totalClientes == 0 ? 0 : (double) totalMotos / totalClientes);
        model.addAttribute("clientes", clienteRepository.findAll());
        model.addAttribute("motos", motoRepository.findAll());
        return "relatorio";
    }
}
