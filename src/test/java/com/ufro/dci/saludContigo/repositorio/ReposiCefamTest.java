package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReposiCefamTest {
    @Autowired
    ReposiDoctor reposiDoctor;
    @Autowired
    ReposiPacien reposiPacien;

    @Autowired
    ReposiCefam reposiCefam;
    ArrayList<Doctor>doctorss;
    ArrayList<Paciente> pacientes;
    Doctor doctor;
    Paciente paciente;

    @BeforeEach
    void beforeEach(){
        doctorss=new ArrayList<Doctor> ();
        pacientes=new ArrayList<Paciente>();
        doctor=new Doctor();
        doctor.setNombre("camila");
        doctor.setApellido("muñoz");
        doctor.setRut("22.222.222-2");
        doctor.setCorreo("camilaMuñoz@gmail.com");
        doctor.setContrasena("1233");
        doctor=reposiDoctor.save(doctor);
        doctorss.add(doctor);
        Paciente paciente=new Paciente();
        paciente.setNombre("fermando");
        paciente.setApellido("martinez");
        paciente.setRut("33.333.333-3");
        paciente.setCorreo("fermando@gmail.com");
        paciente.setContrasena("111");
        paciente=reposiPacien.save(paciente);
        pacientes.add(paciente);
        Cesfam cesfam= new Cesfam();
        cesfam.setDoctores(new ArrayList<>());
        cesfam.setPacientes(new ArrayList<>());
        cesfam.getDoctores().add(doctor);
        cesfam.setNombre("villa alegre");
        cesfam.setPacientes(pacientes);
        cesfam.getPacientes().add(paciente);
        cesfam.getDoctores().add(doctor);
        cesfam=reposiCefam.save(cesfam);
    }
    @Test
    void findByPacientes() {
        Paciente pac1=new Paciente();
        reposiCefam.findByPacientes(paciente);
        pac1.setNombre("roxana");
        pac1.setApellido("sandoval");
        pac1.setRut("9.999.999-9");
        pac1.setCorreo("roxan01@gmail.com");
        pac1.setContrasena("332");
        pac1=reposiPacien.save(pac1);
        Iterable<Cesfam>iterable1= reposiCefam.findByPacientes(pac1);
        boolean tieneCesfam= false;
        for (Cesfam ces : iterable1){
            tieneCesfam=true;
        }
        Assert.isTrue(!tieneCesfam, "Tiene cesfam");
        Iterable<Cesfam>iterable2=reposiCefam.findByPacientes(pac1);
        boolean cesfam=false;
        boolean otroCesfam=true;
        for (Cesfam cesfam1: iterable2){
            otroCesfam=false;
        }
        Assertions.assertNotEquals(!cesfam,!otroCesfam,"los cesfam coinciden");
        Iterable<Cesfam>iterable3=reposiCefam.findByPacientes(pac1);
        boolean cesfam2=true;
        boolean otroCesfam2=true;
        for (Cesfam cesfam1: iterable2){
            cesfam=false;
        }
        Assertions.assertEquals(!cesfam2,!otroCesfam2,"los cesfam no  coinciden");
        Iterable<Cesfam>iterable4=reposiCefam.findByPacientes(pac1);
        boolean notienecesfam=true;
        for (Cesfam cesfam1: iterable4){
            notienecesfam=false;
        }
        Assert.notNull(!notienecesfam,"no se encuentran notas guardadas");
    }

    @Test
    void findByDoctores() {
        Doctor doctor1=new Doctor();
        reposiCefam.findByDoctores(doctor);
        doctor1.setNombre("jose");
        doctor1.setApellido("rodriguez");
        doctor1.setRut("77.777.777-7");
        doctor1.setCorreo("joseR@gmail.com");
        doctor1.setContrasena("332");
        doctor1=reposiDoctor.save(doctor1);
        Iterable<Cesfam>iterable1= reposiCefam.findByDoctores(doctor1);
        boolean tieneCesfam= false;
        for (Cesfam ces : iterable1){
            tieneCesfam=true;
        }
        Assert.isTrue(!tieneCesfam, "Tiene cesfam");
        Iterable<Cesfam>iterable4=reposiCefam.findByDoctores(doctor1);
        boolean notienecesfam=true;
        for (Cesfam cesfam1: iterable1){
            notienecesfam=false;
        }
        Assert.notNull(!notienecesfam,"no se encuentran cesfam guardados");
        Iterable<Cesfam>iterable3=reposiCefam.findByDoctores(doctor1);
        boolean cesfam2=true;
        boolean otroCesfam2=true;
        for (Cesfam cesfam1: iterable3){
            cesfam2=false;
        }
        Assertions.assertEquals(!cesfam2,!otroCesfam2,"los cesfam no  coinciden");
        Iterable<Cesfam>iterable2=reposiCefam.findByDoctores(doctor1);
        boolean cesfam=false;
        boolean otroCesfam=true;
        for (Cesfam cesfam1: iterable2){
            otroCesfam=false;
        }
        Assertions.assertNotEquals(!cesfam,!otroCesfam,"los cesfam coinciden");


    }
}