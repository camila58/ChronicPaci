package com.ufro.dci.saludContigo.repositorio;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReposiPacienTest {
    @Autowired
    ReposiPacien reposiPacien;

    Paciente paciente;

    @BeforeEach
    void setUp(){
        paciente=new Paciente();
        paciente.setIdPaciente((long)1);
        paciente.setNombre("camila");
        paciente.setApellido("muñoz");
        paciente.setCorreo("camila01@gmail.com");
        paciente.setContrasena("1233");
        paciente.setRut("22.222.222-2");
    }
    @Test
    void save(){
        paciente=reposiPacien.save(paciente);
        Assert.notNull(paciente.getIdPaciente(),"id no generado");
        Assert.notNull(paciente.getNombre(),"el nombre no esta ingresado");
    }
    @AfterEach
    void tearDown(){
        //reposiPacien.delete(paciente);
        //paciente=null;
    }
    @Test
    void findByCorreoAndContrasena() {
        paciente=reposiPacien.save(paciente);
        Assert.notNull(reposiPacien.findByCorreoAndContrasena("camila01@gmail.com","1233"),"no existe un paciente con este correo ");
        Assert.isNull(reposiPacien.findByCorreoAndContrasena("luz@gmail.com","123"),"ya se encuentra un paciente con este correo ");
        Assertions.assertEquals("camila01@gmail.com",reposiPacien.findByCorreoAndContrasena("camila01@gmail.com","1233").getCorreo(),"los correos no coiciden");
        Assertions.assertNotSame("1233",reposiPacien.findByCorreoAndContrasena("camila01@gmail.com","1233").getContrasena(),"las contraseñas si coinciden");


    }

    @Test
    void findByCorreo() {
        //paciente=reposiPacien.save(paciente);
        //Assert.hasText(reposiPacien.findByCorreo("camila01@gmail.com").getCorreo(),"no se encuentra el correo");
        //Assertions.assertNotEquals("camila02@gmail.com",reposiPacien.findByCorreo("camila01@gmail.com").getCorreo(),"los correos coinciden");
        //Assert.notNull(reposiPacien.findByCorreo("camila01@gmail.com"),"no se encuentra un paciente con este correo");
        //Assert.isNull(reposiPacien.findByCorreo("camila02@gmail.com"),"este correo ya se encuentra registrado");


    }
    @Test
    void findByContrasena(){
        paciente=reposiPacien.save(paciente);
        Assert.notNull(reposiPacien.findByContrasena("1233").getContrasena(),"las contraseña no coinciden");
        Assert.isNull(reposiPacien.findByContrasena("12121"),"la contraseñas se encuentra incorrecta");
        Assertions.assertNotSame("1233",reposiPacien.findByContrasena("1233").getContrasena(),"las contraseñas si coinciden");
        Assertions.assertNotEquals("12112121",reposiPacien.findByContrasena("1233"),"las contraseñas no coinciden");
    }
}