package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Enfermedades;
import com.ufro.dci.saludContigo.modelo.enumeration.GrupoSanginio;
import com.ufro.dci.saludContigo.repositorio.ReposiFichaM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/fichaMed")
public class ControlFichaMedica {
    @Autowired
    ReposiFichaM fichaM;

    @GetMapping("/paciente")
    public String mostrarF(Model model){
        model.addAttribute("fichamedica",new FichaMedica());
        Iterable<FichaMedica> fichaLis= fichaM.findAll();
        model.addAttribute("grupoS", GrupoSanginio.values());
        model.addAttribute("Enferm", Enfermedades.values());
        model.addAttribute("fichaM",fichaLis);


        return "FichaMedica";
    }
    @PostMapping("/paciente")
    public String guardarDatos(Model model,@ModelAttribute FichaMedica fichaMedica) {
        fichaM.save(fichaMedica);
        System.out.println(fichaMedica);
        return "redirect:/fichaMed/paciente";
    }

}
