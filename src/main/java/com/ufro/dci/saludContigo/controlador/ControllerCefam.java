package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.repositorio.ReposiCefam;
import com.ufro.dci.saludContigo.modelo.Cesfam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/cesfam")
public class ControllerCefam {
    @Autowired
    private ReposiCefam reposiCefam;

    @GetMapping("/registroCesfam")
    public String mostrarCesfam(Model model){
        model.addAttribute("cesfamm",reposiCefam.findAll());
        return "/RegistroCesfam";
    }
    @PostMapping("/registroCesfam")
    public String guardarCesfam(@ModelAttribute Cesfam cesfam){
        reposiCefam.save(cesfam);
        return("/RegistroCesfam");
    }

}
