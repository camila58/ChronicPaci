package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Enfermedades;
import com.ufro.dci.saludContigo.modelo.enumeration.GrupoSanginio;
import com.ufro.dci.saludContigo.repositorio.ReposiFichaM;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.imageio.stream.FileCacheImageInputStream;
import java.util.Optional;

@Controller
@RequestMapping(value = "/fichaMed")
public class ControlFichaMedica {
    @Autowired
    ReposiFichaM fichaM;
    @Autowired
    ReposiPacien repo;

    @GetMapping("/paciente")
    public String mostrarF(Model model){
        model.addAttribute("fichamedica",new FichaMedica());
        FichaMedica fichaLis= null;



        return "FichaMedica";
    }
    @PostMapping("/paciente")
    public String guardarDatos(@ModelAttribute FichaMedica fichaMedica,long id) {

        System.out.println(fichaMedica);

        return "redirect:/fichaMed/paciente";
    }
    @GetMapping("/edit/{id}")
    public String getEditarFicha(Model model, @PathVariable("id") long id){
        Optional<FichaMedica>fichaMedicaOptional=fichaM.findById(id);
        model.addAttribute("grupoS", GrupoSanginio.values());
        model.addAttribute("Enferm", Enfermedades.values());
        model.addAttribute("ficha" ,fichaMedicaOptional.get());
        return "/editTemplate";
    }
    @PostMapping("/edit/{id}")
    public String postEditFicha(@ModelAttribute FichaMedica fichaMedica,@PathVariable ("id") long id){
        Paciente paciente1= repo.findById(id).get();
        fichaMedica.setPaciente(paciente1);
        fichaM.save(fichaMedica);
        System.out.println(fichaMedica);
        return "redirect:/pag/princidoc";
    }
    @GetMapping("/borrar/{id}")
    public String posBorrarFicha(@ModelAttribute FichaMedica fichaMedica,@PathVariable("id") long id){
        FichaMedica fichaas=fichaM.findById(id).get();
        fichaas.setGrupoSanginio(null);
        fichaas.setEnfermedades(null);
        fichaas.setDescripcion(null);
        Paciente paciente=repo.findById(id).get();
        fichaas.setPaciente(paciente);
        fichaM.save(fichaas);
        return "redirect:/pag/princidoc";
    }




}
