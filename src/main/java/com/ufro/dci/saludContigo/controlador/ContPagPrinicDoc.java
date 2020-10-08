package com.ufro.dci.saludContigo.controlador;

import com.ufro.dci.saludContigo.modelo.*;
import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;
import com.ufro.dci.saludContigo.repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value = "/pag")
public class ContPagPrinicDoc {
    Doctor sessionDoct;
    @Autowired
    private ReposiDoctor reposiDoctor;
    @Autowired
    private ReposiBlocNota blocNota;
    @Autowired
    private ReposiHorario reposiHorario;
    @Autowired
    private ReposiBlocNota reposiBlocNota;
    @Autowired
    private ReposiPacien reposiPacien;
    @Autowired
    private ReposiFichaM fichaM;

    @GetMapping("/princidoc")
    public String mostrarPag(Model model, HttpServletRequest request,@ModelAttribute FichaMedica fichaMedica){
        Iterable<FichaMedica >fichaMedica1=  fichaM.findAll();
        sessionDoct=(Doctor)request.getSession().getAttribute("doctorLogueado");
        if (sessionDoct==null){
            return("redirect:/pag/login");
        }
        Optional<Doctor> doctortemp=reposiDoctor.findById(sessionDoct.getIdDoctor());
        Map<String,String>asignada = getMapHorario();
        for(Horario hor :reposiHorario.findByDoctor(doctortemp.get())){
            String attribute=hor.getDia().getDiaFinal()+hor.getPeriodo().getDiaFinal();
            asignada.put(attribute,"" +doctortemp.get().getNombre());
        }
        model.addAttribute("asign",asignada);
        model.addAttribute("notas",reposiBlocNota.findByDoctor(doctortemp.get()));
        model.addAttribute("fich",fichaMedica1);
        return("PagPrinciDoctor");

    }
    @GetMapping("/agregar/{dia}/{period}")
    public String Guardarhora(@PathVariable("dia") int dia, @PathVariable("period") int periodo, HttpServletRequest request) {
        Optional<Doctor> docTemp = reposiDoctor.findById(sessionDoct.getIdDoctor());
        Horario ho = reposiHorario.findByPeriodoAndDia(Periodo.getPeriodoByNum(periodo), Dia.getDiaByNum(dia));
        if (docTemp.isPresent() && ho == null) {
            Doctor doctor = docTemp.get();
            Horario hor = new Horario();
            hor.setDia(Dia.getDiaByNum(dia));
            hor.setDoctor(doctor);
            hor.setPeriodo(Periodo.getPeriodoByNum(periodo));
            reposiHorario.save(hor);
        }
        return "redirect:/pag/princidoc";
    }
    @PostMapping("/pagBloc")
    public String GuardarNota(@ModelAttribute BlocNota blocNota){
        BlocNota blocTemp=reposiBlocNota.save(blocNota);
        Optional<Doctor> docTemp=reposiDoctor.findById(sessionDoct.getIdDoctor());
        if(docTemp.isPresent()){
           blocNota.setDoctor(docTemp.get());
           reposiBlocNota.save(blocNota);
        }
        return"redirect:/pag/princidoc";
    }
    @GetMapping("/borrarNota/{id}")
    public String borrarNotas(@ModelAttribute BlocNota blocNota,@PathVariable("id")long id){
        BlocNota blocNota1=reposiBlocNota.findById(id).get();
        reposiBlocNota.delete(blocNota1);

        return "redirect:/pag/princidoc";
    }
    @GetMapping("/editDoc/{id}")
    public String getEditarDoct(Model model,@PathVariable("id")long id){
        Optional<Doctor>doctorO=reposiDoctor.findById(id);
        model.addAttribute("doctor",doctorO.get());
        return "editarDoctor";
    }
    @PostMapping("/editarDoctor")
    public String postEditarDoct(@ModelAttribute Doctor doctor, HttpServletRequest request, Model model){
        if(sessionDoct.getContrasena().equals(doctor.getContrasena())){

            sessionDoct.setNombre(doctor.getNombre());
            sessionDoct.setApellido(doctor.getApellido());
            sessionDoct.setCorreo(doctor.getCorreo());
            reposiDoctor.save(sessionDoct);
            return "redirect:/pag/princidoc";
        }
        model.addAttribute("error","la contraseña no coinciden");
        return "redirect:/pag/editDoc/"+sessionDoct.getIdDoctor();
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
