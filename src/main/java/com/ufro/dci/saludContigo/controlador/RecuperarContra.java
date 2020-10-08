package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.repositorio.ReposiDoctor;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Properties;

@Controller
@RequestMapping(value = "/cuenta")
public class RecuperarContra {
    @Autowired
    ReposiPacien reposiPacien;

    @Autowired
    ReposiDoctor reposiDoctor;

    @GetMapping("/recuperar")
    public String mostrarFor(Model model){
        model.addAttribute("message","");
        return("RecupeCuenta");
    }
    @RequestMapping(value="/recuperar", method= RequestMethod.POST)
    public String forgotUserPassword(Model model, Doctor user) {
        Doctor existingUser = reposiDoctor.findByCorreo(user.getCorreo());
        if (existingUser != null) {
            JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
            mailSender.setHost("smtp.gmail.com");
            mailSender.setPort(587);
            mailSender.setUsername("chronic.patient02@gmail.com");
            mailSender.setPassword("japtvlbesubtbhkx");

            Properties props = mailSender.getJavaMailProperties();
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.debug", "true");

            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(existingUser.getCorreo());
            mailMessage.setSubject("Complete Password Reset!");
            mailMessage.setFrom("chronic.patient02@gmail.com");
            mailMessage.setText("Tu contrasena es: "+ existingUser.getContrasena());
            mailSender.send(mailMessage);
            model.addAttribute("message", "Tu contraseña ha sido enviada al correo.");
            return "RecupeCuenta";
        } else {
            model.addAttribute("message", "El correo ingresado no esta registrado");
            return "RecupeCuenta";
        }
    }

}
