package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/paciente")
public class ControllerPaciente {
    private Doctor doctor;
    @Autowired(required = true)
    private ReposiPacien reposiPacien;

    @GetMapping("/login")
    public String mostrarFormula(Model model){
        model.addAttribute("paciente",new Paciente());
        return "loginPaciente";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute Paciente paciente, HttpServletRequest request,Model model){
        paciente.getNombre();
        Paciente pacienteBd=reposiPacien.findByCorreoAndContrasena(paciente.getCorreo(),paciente.getContrasena());
        if(pacienteBd!= null){
            request.getSession().setAttribute("pacienteLogueado",pacienteBd);
            return "redirect:/principal/princiPacien";
        }else{
            model.addAttribute("paciente",new Paciente());
            model.addAttribute("error",true);
            return "redirect:/paciente/login";
        }


    }
    @GetMapping("/logout")
    public String logout(Model model,HttpServletRequest request){
        request.getSession().setAttribute("usuarioLogueado",null);
        return "redirect:/paciente/login";
    }

}
