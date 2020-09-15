package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Horario;
import com.ufro.dci.saludContigo.repositorio.ReposiHorario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/agregar")
public class ControlHorario {
    Doctor doctor1;
    @Autowired
    private ReposiHorario reposiHorario;

    @GetMapping("/hora")
    public String mostrarFor() {
        return "PagPrinciDoctor";
    }

    @PostMapping("/guardar")
    public String guardarDato(Horario horario, HttpServletRequest request){
        doctor1=(Doctor) request.getSession().getAttribute("doctorLogueado");
        horario.setDoctor(doctor1);
        reposiHorario.save(horario);
        return"PagPrinciDoctor";
    }
    @DeleteMapping("/borrarHorario")
    public String borrarPeriodo(@ModelAttribute Horario horario,HttpServletRequest request){
        doctor1=(Doctor) request.getSession().getAttribute("doctorLogueado");
        reposiHorario.delete(horario);
        return "PagPrinciDoctor";
    }
}
