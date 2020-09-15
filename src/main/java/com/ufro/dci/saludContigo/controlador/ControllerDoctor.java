package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.repositorio.ReposiCefam;
import com.ufro.dci.saludContigo.repositorio.ReposiDoctor;
import com.ufro.dci.saludContigo.repositorio.ReposiEspecialidad;
import com.ufro.dci.saludContigo.modelo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/pag")
public class ControllerDoctor {
    @Autowired
    private ReposiDoctor reposiDoctor;

    @Autowired
    private ReposiCefam cefam;

    @Autowired
    private ReposiEspecialidad reposiEspecialidad;

    @GetMapping("/login")
    public String mostrarformula(Model model){
        model.addAttribute("doctor",new Doctor());
        return "loginDoctor";

    }
    @PostMapping("/login")
    public String login(@ModelAttribute Doctor doctor, HttpServletRequest request, Model model){
        System.out.println(doctor);
        Doctor doctorBd=reposiDoctor.findByCorreoAndContrasena(doctor.getCorreo(),doctor.getContrasena());
        System.out.println(doctorBd);
         if(doctorBd!= null){
             request.getSession().setAttribute("doctorLogueado",doctorBd);
             return "redirect:/pag/princidoc";
         }else{
             model.addAttribute("doctor", new Doctor());
             model.addAttribute("error",true);
             return"redirect:/pag/login";
         }



    }
    @GetMapping("/logout")
    public String logout(Model model,HttpServletRequest request){
        request.getSession().setAttribute("doctorLogueado",null);
        return "redirect:/pag/login";
    }

}
