package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Remedio;
import com.ufro.dci.saludContigo.repositorio.ReposiRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/remedio")
public class ControlRemedio {
    @Autowired
    private ReposiRemedio reposiRemedio;

    @GetMapping("/paciente")
    public String mostrarFor(Model model){
        model.addAttribute("remedio",new Remedio());
        Iterable<Remedio>remedios=reposiRemedio.findAll();
        model.addAttribute("remedios",remedios);
        return "Remedio";
    }
    @PostMapping("/paciente")
    public String guardarDato(Model model, @ModelAttribute Remedio remedio){
        reposiRemedio.save(remedio);
        System.out.println(remedio);
        return"redirect:/remedio/paciente";
    }

}
