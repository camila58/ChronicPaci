package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Horario;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReposiHorarioTest {

    @Autowired
    ReposiHorario reposiHorario;
    @Autowired
    ReposiPacien reposiPacien;
    @Autowired
    ReposiDoctor reposiDoctor;

    Doctor doctor;
    Paciente paciente;

    @BeforeEach
    void beforeEach(){
        paciente= new Paciente();
        paciente.setNombre("camila");
        paciente.setApellido("muñoz");
        paciente.setRut("33.333.222-1");
        paciente.setCorreo("camilaMuñoz@gmail.com");
        paciente.setContrasena("111");
        paciente=reposiPacien.save(paciente);
        doctor=new Doctor();
        doctor.setNombre("luz");
        doctor.setApellido("pichintines");
        doctor.setCorreo("luzP@gmail.com");
        doctor.setRut("12.222.111-2");
        doctor.setContrasena("3334");
        doctor=reposiDoctor.save(doctor);
        Horario horario=new Horario();
        horario.setDoctor(doctor);
        horario.setPaciente(paciente);
        horario.setPeriodo(Periodo.UNO);
        horario.setDia(Dia.DOMINGO);
        horario=reposiHorario.save(horario);

    }
    @Test
    void findByPeriodoAndDia() {
        Horario horario2=new Horario();
        horario2.setDia(Dia.MARTES);
        horario2.setPeriodo(Periodo.SEIS);
        horario2=reposiHorario.save(horario2);
        reposiHorario.findByPeriodoAndDia(Periodo.CUATRO,Dia.JUEVES);
        //Assert.notNull(reposiHorario.findByPeriodoAndDia(Periodo.UNO,Dia.DOMINGO), "no se encontro el dia ni el periodo en el horario");
        //Assert.isNull(reposiHorario.findByPeriodoAndDia(Periodo.OCHO,Dia.MIERCOLES),"este periodo y dia ya se encuentran registrados en el horario");
        //Assertions.assertEquals(Periodo.UNO,reposiHorario.findByPeriodoAndDia(Periodo.UNO,Dia.DOMINGO).getPeriodo(),"los periodos no coinciden");
        //Assertions.assertNotEquals(Periodo.CUATRO,reposiHorario.findByPeriodoAndDia(Periodo.TRES, Dia.DOMINGO), "los periodos coinciden");
    }

    @Test
    void findByPaciente() {
        Paciente paciente1=new Paciente();
        reposiHorario.findByPaciente(paciente);
        paciente1.setNombre("jorge");
        paciente1.setApellido("fernandez");
        paciente1.setRut("44.444.111-1");
        paciente1.setCorreo("jorgeFern@gmail.com");
        paciente1.setContrasena("3321");
        paciente1=reposiPacien.save(paciente1);
        Iterable<Horario>horarioIterable=reposiHorario.findByPaciente(paciente1);
        boolean tieneHorario=false;
        for (Horario horario: horarioIterable){
            tieneHorario=true;
        }
        Assert.isTrue(!tieneHorario,"tiene horario");

        Iterable<Horario>horarioIterable2=reposiHorario.findByPaciente(paciente1);
        boolean Horario=false;
        boolean otroHorario=true;
        for (Horario horario: horarioIterable2){
            otroHorario=true;
        }
        Assertions.assertNotEquals(!otroHorario,"los  horario coinciden");
        Iterable<Horario>iterable3=reposiHorario.findByPaciente(paciente1);
        boolean horario3=true;
        boolean horario2=true;
        for (Horario horario1: iterable3){
            otroHorario=false;
        }
        Assertions.assertEquals(!horario3,!horario2,"los horarios no  coinciden");
        Iterable<Horario>iterable4=reposiHorario.findByPaciente(paciente1);
        boolean notienehorario=true;
        for (Horario h1: iterable4){
            notienehorario=false;
        }
        Assert.notNull(!notienehorario,"no se encuentran horarios guardadas");

    }

    @Test
    void findByDoctor() {
        Doctor doctor1 = new Doctor();
        reposiHorario.findByDoctor(doctor);
        doctor1.setNombre("jose miguel");
        doctor1.setApellido("pinilla");
        doctor1.setRut("11.221.122-1");
        doctor1.setCorreo("jose@gmail.com");
        doctor1.setContrasena("1421");
        doctor1 = reposiDoctor.save(doctor1);
        Iterable<Horario> iterable4 = reposiHorario.findByDoctor(doctor1);
        boolean notienehorario = true;
        for (Horario h1 : iterable4) {
            notienehorario = false;
        }
        Assert.notNull(!notienehorario, "no se encuentran horarios guardadas");
        Iterable<Horario> iterable3 = reposiHorario.findByDoctor(doctor1);
        boolean horario3 = true;
        boolean horario2 = true;
        for (Horario horario1 : iterable3) {
            boolean horariofa = false;
        }
        Assertions.assertEquals(!horario3, !horario2, "los horarios no  coinciden");
        Iterable<Horario>horarioIterable2=reposiHorario.findByDoctor(doctor1);
        boolean Horario=false;
        boolean otroHorario=true;
        for (Horario horario: horarioIterable2){
            otroHorario=true;
        }
        Assertions.assertNotEquals(!otroHorario,"los  horario coinciden");
        Iterable<Horario>horarioIterable=reposiHorario.findByDoctor(doctor1);
        boolean tieneHorario=false;
        for (Horario horario: horarioIterable){
            tieneHorario=true;
        }
        Assert.isTrue(!tieneHorario,"tiene horario");

    }
}