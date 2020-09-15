package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.enumeration.TipoCefam;
import com.ufro.dci.saludContigo.modelo.enumeration.TipoEspecialidades;
import com.ufro.dci.saludContigo.repositorio.ReposiCefam;
import com.ufro.dci.saludContigo.repositorio.ReposiDoctor;
import com.ufro.dci.saludContigo.repositorio.ReposiEspecialidad;
import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/regisDoct")
public class ConPagRegisDoctor {
    @Autowired(required = true)
    private ReposiDoctor reposiDoctor;
    @Autowired(required = true)
    private ReposiEspecialidad reposiEspecialidad;
    @Autowired(required = true)
    private ReposiCefam reposiCefam;

    @GetMapping("/regis")
    public String mostrarformula(Model model){
        Iterable<Cesfam>cefamIterable=reposiCefam.findAll();
        Iterable<Especialidad>especialidads=reposiEspecialidad.findAll();
        model.addAttribute("cefams", TipoCefam.values());
        model.addAttribute("especialidad", TipoEspecialidades.values());
        model.addAttribute(reposiDoctor.findAll());
        model.addAttribute("Error_mensaje","");
        return"RegistrarseDoctor";
    }
    @PostMapping("/regis")
    public String guardarDoctor(Model model, @ModelAttribute Doctor doctor){
       Doctor doctor1=reposiDoctor.findByCorreo(doctor.getCorreo());
        System.out.println(doctor);
       if(doctor1!=null){
           model.addAttribute("error_mensaje","Este correo ya se encuentra registrado");
           return "RegistrarseDoctor";
       }
       reposiDoctor.save(doctor);
        return "redirect:/saludContigo/";
    }
}
