package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.*;
import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;
import com.ufro.dci.saludContigo.repositorio.ReposiBlocNota;
import com.ufro.dci.saludContigo.repositorio.ReposiHorario;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
import com.ufro.dci.saludContigo.repositorio.ReposiRemedio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller()
@RequestMapping(value = "/principal")
public class ContPagPrinciPacie {

    Paciente pacienteSession;
    @Autowired
    private ReposiPacien reposiPacien;
    @Autowired
    private ReposiHorario reposiHorario;
    @Autowired
    private ReposiBlocNota reposiBlocNota;
    @Autowired
    private ReposiRemedio reposiRemedio;

    @GetMapping("/princiPacien")
    public String mostrarPag(Model model, HttpServletRequest request,@ModelAttribute Remedio remedio){
        Iterable<Remedio>remedio1= reposiRemedio.findAll();
        pacienteSession=(Paciente)request.getSession().getAttribute("pacienteLogueado");
        if(pacienteSession==null){
            return ("redirect:/paciente/login");
        }
        Optional<Paciente>horaTemp=reposiPacien.findById(pacienteSession.getIdPaciente());
        Map<String,String> asignad = getMapHorario();
        for(Horario hor :reposiHorario.findByPaciente(reposiPacien.findById(horaTemp.get().getIdPaciente()).get())){
            String attribute=hor.getDia().getDiaFinal()+hor.getPeriodo().getDiaFinal();
            asignad.put(attribute,"Remedio");
        }
        model.addAttribute("asign",asignad);
        model.addAttribute("notas", reposiBlocNota.findByPaciente(horaTemp.get()));
        model.addAttribute("remedio",remedio1);

        return ("pagPrinciPaciente");
    }
    @GetMapping("/agregar/{dia}/{period}")
    public String Guardarhora(@PathVariable("dia") int dia, @PathVariable("period") int periodo, HttpServletRequest request) {
        Optional<Paciente> pacieTemp = reposiPacien.findById(pacienteSession.getIdPaciente());
        Horario ho = reposiHorario.findByPeriodoAndDia(Periodo.getPeriodoByNum(periodo), Dia.getDiaByNum(dia));
        if (pacieTemp.isPresent() && ho == null) {
            Paciente paciente = pacieTemp.get();
            Horario hor = new Horario();
            hor.setDia(Dia.getDiaByNum(dia));
            hor.setPaciente(paciente);
            hor.setPeriodo(Periodo.getPeriodoByNum(periodo));
            reposiHorario.save(hor);
        }
        return "redirect:/principal/princiPacien";
    }
    @PostMapping("/pagBloc")
    public String GuardarNota(@ModelAttribute BlocNota blocNota){
        BlocNota blocTemp=reposiBlocNota.save(blocNota);
        Optional<Paciente> pacienTemp=reposiPacien.findById(pacienteSession.getIdPaciente());
        if(pacienTemp.isPresent()){
            blocNota.setPaciente(pacienTemp.get());
            reposiBlocNota.save(blocNota);
        }
        return"redirect:/principal/princiPacien";
    }
    @PostMapping("/agregarRemedio")
    public String guardarRemedio(@ModelAttribute Remedio remedio){
        Remedio remedio1=reposiRemedio.save(remedio);
        Optional<Paciente>pacienteOptional=reposiPacien.findById(pacienteSession.getIdPaciente());
        if (pacienteOptional.isPresent()){
            remedio1.setPaciente(pacienteOptional.get());
            reposiRemedio.save(remedio1);
        }
        return"redirect:/principal/princiPacien";
    }
    @GetMapping("/borrarRemedio/{id}")
    public String borrarRemedio(@ModelAttribute Remedio remedio,@PathVariable("id") long id ){
        Remedio remedio1=reposiRemedio.findById(id).get();
        reposiRemedio.delete(remedio1);

        return "redirect:/principal/princiPacien";

    }
    @GetMapping("/borrarNotas/{id}")
    public String borrarNotas(@ModelAttribute BlocNota blocNota,@PathVariable("id")long id){
        BlocNota blocNota1=reposiBlocNota.findById(id).get();
        reposiBlocNota.delete(blocNota1);

        return "redirect:/principal/princiPacien";
    }
    @GetMapping("/edit/{id}")
    public String getEditUser(Model model,@PathVariable("id") long id){
        Optional<Paciente> pacienteO = reposiPacien.findById(id);
        model.addAttribute("pacie",pacienteO.get());
        System.out.println(pacienteO);
        return "editarPacient";
    }
    @PostMapping("/editarPacie")
    public String postEditUser(@ModelAttribute Paciente paciente, HttpServletRequest request, Model model){
        if(pacienteSession.getContrasena().equals(paciente.getContrasena())){

            pacienteSession.setNombre(paciente.getNombre());
            pacienteSession.setApellido(paciente.getApellido());
            pacienteSession.setCorreo(paciente.getCorreo());
            reposiPacien.save(pacienteSession);
            System.out.println(paciente);
            return "redirect:/principal/princiPacien";
        }else{
            model.addAttribute("errorPacie","la contraseña no coinciden");
            return "redirect:/principal/edit/"+pacienteSession.getIdPaciente();
        }
    }

    private Map<String, String> getMapHorario() {
        Map<String,String> asignad = new HashMap<>();
        asignad.put("lunesNO","+");
        asignad.put("lunesOO","+");
        asignad.put("lunesOF","+");
        asignad.put("lunesFS","+");
        asignad.put("lunesSN","+");
        asignad.put("lunesNE","+");
        asignad.put("lunesNI","+");
        asignad.put("lunesNT","+");

        asignad.put("martesNO","+");
        asignad.put("martesOO","+");
        asignad.put("martesOF","+");
        asignad.put("martesFS","+");
        asignad.put("martesSN","+");
        asignad.put("martesNE","+");
        asignad.put("martesNI","+");
        asignad.put("martesNT","+");

        asignad.put("miercolesNO","+");
        asignad.put("miercolesOO","+");
        asignad.put("miercolesOF","+");
        asignad.put("miercolesFS","+");
        asignad.put("miercolesSN","+");
        asignad.put("miercolesNE","+");
        asignad.put("miercolesNI","+");
        asignad.put("miercolesNT","+");

        asignad.put("juevesNO","+");
        asignad.put("juevesOO","+");
        asignad.put("juevesOF","+");
        asignad.put("juevesFS","+");
        asignad.put("juevesSN","+");
        asignad.put("juevesNE","+");
        asignad.put("juevesNI","+");
        asignad.put("juevesNT","+");

        asignad.put("viernesNO","+");
        asignad.put("viernesOO","+");
        asignad.put("viernesOF","+");
        asignad.put("viernesFS","+");
        asignad.put("viernesSN","+");
        asignad.put("viernesNE","+");
        asignad.put("viernesNI","+");
        asignad.put("viernesNT","+");

        asignad.put("sabadoNO","+");
        asignad.put("sabadoOO","+");
        asignad.put("sabadoOF","+");
        asignad.put("sabadoFS","+");
        asignad.put("sabadoSN","+");
        asignad.put("sabadoNE","+");
        asignad.put("sabadoNI","+");
        asignad.put("sabadoNT","+");

        asignad.put("domingoNO","+");
        asignad.put("domingoOO","+");
        asignad.put("domingoOF","+");
        asignad.put("domingoFS","+");
        asignad.put("domingoSN","+");
        asignad.put("domingoNE","+");
        asignad.put("domingoNI","+");
        asignad.put("domingoNT","+");

        return asignad;
    }



}
