package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.Remedio;
import com.ufro.dci.saludContigo.modelo.enumeration.TipoCefam;
import com.ufro.dci.saludContigo.repositorio.ReposiCefam;
import com.ufro.dci.saludContigo.repositorio.ReposiFichaM;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import com.ufro.dci.saludContigo.repositorio.ReposiRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/pagPaciente")
public class ConPagRegisPaciente {
    @Autowired(required = true)
    private ReposiPacien reposiPacien;
    @Autowired(required = true)
    private ReposiCefam reposiCefam;
    @Autowired
    private ReposiFichaM fichaM;
    @Autowired
    private ReposiRemedio reposiRemedio;

    @GetMapping("/regis")
    public String mostrarForm(Model model){
        Iterable<Cesfam>cesfams=reposiCefam.findAll();
        model.addAttribute("cefamm", TipoCefam.values());
        model.addAttribute(reposiPacien.findAll());
        model.addAttribute("error_mensaje","");
        return "RegistrarsePaciente";
    }
    @PostMapping("/regis")
    public String GuardarPaciente(Model model, @ModelAttribute Paciente paciente){
        Paciente paciente1=reposiPacien.findByCorreo(paciente.getCorreo());
        if (paciente1!= null){
            model.addAttribute("error_","Este correo ya se encuentra registrado");
            return "RegistrarsePaciente";
        }
        FichaMedica fichaMedica= new FichaMedica();
        paciente=reposiPacien.save(paciente);
        fichaMedica.setPaciente(paciente);
        fichaM.save(fichaMedica);
        Remedio remedio=new Remedio();
        paciente=reposiPacien.save(paciente);
        remedio.setPaciente(paciente);
        reposiRemedio.save(remedio);
        reposiPacien.save(paciente);
        return"redirect:/saludContigo/";
    }
}
