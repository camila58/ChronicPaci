package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.Doctor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReposiDoctorTest {
    @Autowired
    ReposiDoctor reposiDoctor;

    Doctor doctor;
    @BeforeEach
    void setUp(){
        doctor=new Doctor();
        doctor.setIdDoctor((long) 1);
        doctor.setNombre("luz");
        doctor.setApellido("pichintines");
        doctor.setCorreo("luz@gmail.com");
        doctor.setContrasena("12");
        doctor.setRut("11.111.111-1");

    }
    @AfterEach
    void tearDown(){
        //reposiDoctor.delete(doctor);
        //doctor=null;
    }
    @Test
    void save(){
        doctor=reposiDoctor.save(doctor);
        Assert.notNull(doctor.getIdDoctor(),"Id no generado");
    }

    @Test
    void findByCorreoAndContrasena() {
        doctor=reposiDoctor.save(doctor);
        Assert.notNull(reposiDoctor.findByCorreoAndContrasena("luz@gmail.com","12"),"No Existe un doctor con este correo o contraseña");
        Assertions.assertEquals("luz@gmail.com",reposiDoctor.findByCorreoAndContrasena("luz@gmail.com","12").getCorreo(),"los correos no coiciden");
        Assertions.assertNotSame("12",reposiDoctor.findByCorreoAndContrasena("luz@gmail.com","12").getContrasena(),"las contraseñas si coinciden");
        Assert.isNull(reposiDoctor.findByCorreoAndContrasena("camila@gmail.com","12"),"hay un doctor con este doctor o contraseña");
    }

    @Test
    void findByCorreo() {
        //doctor=reposiDoctor.save(doctor);
        //Assert.hasText(reposiDoctor.findByCorreo("luz@gmail.com").getCorreo(), "no se encuentra correo");
        //Assert.notNull(reposiDoctor.findByCorreo("luz@gmail.com"),"no se encontro un doctor con este correo");
        //Assert.isNull(reposiDoctor.findByCorreo("camila01@gmail.com"),"ya existe un doctor con este correo");
        //Assertions.assertNotEquals("correo@correo.com",reposiDoctor.findByCorreo("luz@gmail.com").getCorreo(),"los correos coinciden");
    }
    @Test
    void finByContrasena(){
        doctor=reposiDoctor.save(doctor);
        Assert.notNull(reposiDoctor.findByContrasena("12").getContrasena(),"la contraseña no coincide");
        Assert.isNull(reposiDoctor.findByContrasena("1232"),"la contraseña se encuentra incorrecta");
        Assertions.assertNotSame("12",reposiDoctor.findByContrasena("12").getContrasena(),"las contraseñas si coinciden");
        Assertions.assertNotEquals("123238438",reposiDoctor.findByContrasena("12").getContrasena(),"las contraseña no coinciden");
    }
}