package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReposiBlocNotaTest {
    @Autowired
    ReposiDoctor reposiDoctor;
    @Autowired
    ReposiPacien reposiPacien;
    @Autowired
    ReposiBlocNota reposiBlocNota;
    Doctor doctor;
    Paciente paciente;

    @BeforeEach
    void beforeEach(){

        doctor=new Doctor();
        doctor.setNombre("luz");
        doctor.setApellido("pichintines");
        doctor.setRut("11.111.111-1");
        doctor.setCorreo("luz@gmail.com");
        doctor.setContrasena("123");
        doctor=reposiDoctor.save(doctor);
        Paciente paciente=new Paciente();
        paciente.setNombre("camila ");
        paciente.setApellido("muñoz");
        paciente.setRut("22.222.222-2");
        paciente.setCorreo("camila01@gmail.com");
        paciente.setContrasena("122");
        paciente=reposiPacien.save(paciente);
        BlocNota blocNota=new BlocNota();
        blocNota=reposiBlocNota.save(blocNota);
        blocNota.setDoctor(doctor);
        blocNota.setPaciente(paciente);
        blocNota.setTexto("hola mundo");
        blocNota=reposiBlocNota.save(blocNota);

    }
    @Test
    void findByPaciente() {
        Paciente paci1 = new Paciente();
        reposiBlocNota.findByPaciente(paciente);
        paci1.setNombre("roxana");
        paci1.setApellido("sandoval");
        paci1.setRut("55.555.555-5");
        paci1.setCorreo("roxana@gmail.com");
        paci1.setContrasena("112");
        paci1 = reposiPacien.save(paci1);
        Iterable<BlocNota> iterable = (Iterable<BlocNota>) reposiBlocNota.findByPaciente(paci1);
        boolean tieneNota = false;
        for (BlocNota bloc : iterable) {
            tieneNota = true;
        }
        Assert.isTrue(!tieneNota,"Tiene nota guardada");
        Iterable<BlocNota>iterable1=(Iterable<BlocNota>) reposiBlocNota.findByPaciente(paci1);
        boolean notieneNota=true;
        for (BlocNota bloc: iterable1){
            notieneNota=false;
        }
        Assert.notNull(!notieneNota,"no se encuentran notas guardadas");
        Iterable<BlocNota>iterable2=(Iterable<BlocNota>) reposiBlocNota.findByPaciente(paci1);
        boolean notas=false;
        boolean noNota=true;
        for (BlocNota bloc: iterable2){
            noNota=false;
        }
        Assertions.assertNotEquals(!notas,!noNota,"los notas coinciden");
        Iterable<BlocNota>iterable3=(Iterable<BlocNota>) reposiBlocNota.findByPaciente(paci1);
        boolean notasPac=true;
        boolean noNotaPc=true;
        for (BlocNota bloc: iterable2){
            noNota=false;
        }
        Assertions.assertEquals(!notasPac,!noNotaPc,"los notas no  coinciden");



    }

    @Test
    void findByDoctor() {
        Doctor doc2=new Doctor();
        reposiBlocNota.findByDoctor(doctor);
        doc2.setNombre("maria");
        doc2.setApellido("perez");
        doc2.setRut("88.999.999-9");
        doc2.setCorreo("maria@gmail.com");
        doc2.setContrasena("12321");
        doc2=reposiDoctor.save(doc2);
        Iterable<BlocNota> iterable = (Iterable<BlocNota>) reposiBlocNota.findByDoctor(doc2);
        boolean tieneNota = false;
        for (BlocNota bloc : iterable) {
            tieneNota = true;
        }
        Assert.isTrue(!tieneNota,"Tiene nota guardada");
        Iterable<BlocNota>iterable1=(Iterable<BlocNota>) reposiBlocNota.findByDoctor(doc2);
        boolean notieneNota=true;
        for (BlocNota bloc: iterable1){
            notieneNota=false;
        }
        Assert.notNull(!notieneNota,"no se encuentran notas guardadas");
        Iterable<BlocNota>iterable2=(Iterable<BlocNota>) reposiBlocNota.findByDoctor(doc2);
        boolean notas=false;
        boolean noNota=true;
        for (BlocNota bloc: iterable2){
            noNota=false;
        }
        Assertions.assertNotEquals(!notas,!noNota,"los notas coinciden");
        Iterable<BlocNota>iterable3=(Iterable<BlocNota>) reposiBlocNota.findByDoctor(doc2);
        boolean notasDoc=true;
        boolean noNotadoc=true;
        for (BlocNota bloc: iterable2){
            noNota=false;
        }
        Assertions.assertEquals(!notasDoc,!noNotadoc,"los notas no  coinciden");

    }
}