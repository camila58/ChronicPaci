package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pagPacien")
public class ContrPagPrinciPacien {
    Paciente sessionPaciente;
    @Autowired(required = true)
    private ReposiPacien reposiPacien;

    @GetMapping("/pagPrinci")
    public String mostrarPag(Model model, HttpServletRequest request){
        sessionPaciente=(Paciente)request.getSession().getAttribute("pacienteLogueado");
        if (sessionPaciente== null){
            return ("redirect:/login");
        }
        return("pagPrinciPaciente");

    }

}
