package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Horario;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;
import com.ufro.dci.saludContigo.repositorio.ReposiBlocNota;
import com.ufro.dci.saludContigo.repositorio.ReposiHorario;
import com.ufro.dci.saludContigo.repositorio.ReposiPacien;
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

    @GetMapping("/princiPacien")
    public String mostrarPag(Model model, HttpServletRequest request){
        Iterable<Paciente> pacienList= reposiPacien.findAll();
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
        model.addAttribute("pacientes",pacienList);
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
