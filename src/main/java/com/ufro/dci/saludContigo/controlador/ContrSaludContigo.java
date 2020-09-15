package com.ufro.dci.saludContigo.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/saludContigo")
public class ContrSaludContigo {

    @GetMapping("/")
    public String mostrarPag(){ return "SaludContigo";
    }
    @GetMapping("/registro")
    public String mostrarPagina(){
        return "PaginaRegistro";
    }

    @GetMapping("/loguear")
    public String mostrarPagi(){
        return "Loguearse";
    }

}
