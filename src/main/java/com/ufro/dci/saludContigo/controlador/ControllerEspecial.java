package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Especialidad;
import com.ufro.dci.saludContigo.repositorio.ReposiEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller(value = "/especialidad")
public class ControllerEspecial {
    @Autowired
    private ReposiEspecialidad reposiEspecialidad;

    @GetMapping("registroEspeci")
    public String mostrarEspeciali(Model model){
        model.addAttribute("especialidades",reposiEspecialidad.findAll());
        return"/RegistroEspecialidad";
    }
    @PostMapping("/registroEspeci")
    public String guardarEspecialidad(@ModelAttribute Especialidad especialidad){
        reposiEspecialidad.save(especialidad);
        return"/RegistroEspecialidad";
    }
}
