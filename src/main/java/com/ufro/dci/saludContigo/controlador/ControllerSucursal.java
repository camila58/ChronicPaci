package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.repositorio.ReposiCefam;
import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Sucursal;
import com.ufro.dci.saludContigo.repositorio.ReposiSucursal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
@RequestMapping(value = "/sucursal")
public class ControllerSucursal {
    @Autowired(required = true)
    private ReposiCefam reposiCefam;
    @Autowired(required = true)
    private ReposiSucursal reposiSucursal;

    @GetMapping("/registroSucu")
    public String mostrarDato(Model model){
        ArrayList<Cesfam>cefams=(ArrayList<Cesfam>) reposiCefam.findAll();
        model.addAttribute("cefams",cefams);
        return "RegistroSucurs";
    }
    @PostMapping("registroSucu")
    public String guardarSucursal(@ModelAttribute Sucursal sucursal){
        reposiSucursal.save(sucursal);
        return "RegistroSucurs";
    }
}
