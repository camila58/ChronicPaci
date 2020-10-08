package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Enfermedades;
import com.ufro.dci.saludContigo.modelo.enumeration.GrupoSanginio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ReposiFichaMTest {
    @Autowired
    ReposiPacien reposiPacien;

    @Autowired
    ReposiFichaM reposiFichaM;

    Paciente paciente;

    @BeforeEach
    void beforeEach(){
        paciente=new Paciente();
        paciente.setNombre("luz");
        paciente.setApellido("pichintines");
        paciente.setRut("11.111.111-1");
        paciente.setCorreo("luz@gmail.com");
        paciente.setContrasena("12");
        paciente=reposiPacien.save(paciente);
        FichaMedica fichaMedica=new FichaMedica();
        fichaMedica.setPaciente(paciente);
        fichaMedica.setNombre("luz");
        fichaMedica.setEnfermedades(Enfermedades.ALZHEIMER);
        fichaMedica.setGrupoSanginio(GrupoSanginio.GRUPOA);
        fichaMedica.setDescripcion("toma remedio todos los dias ");
        fichaMedica=reposiFichaM.save(fichaMedica);
    }
    @Test
    void findByPaciente() {
     Paciente paci2= new Paciente();
     reposiFichaM.findByPaciente(paciente);
        paci2.setNombre("camila");
        paci2.setApellido("muñoz");
        paci2.setRut("33.333.333-3");
        paci2.setCorreo("camila02@gmail.com");
        paci2.setContrasena("112");
        paci2=reposiPacien.save(paci2);
        Assert.notNull(reposiFichaM.findByPaciente(paciente),"no se encontro una ficha medica de paciente");
        Assert.isNull(reposiFichaM.findByPaciente(paci2),"este paciente ya cuenta con una ficha medica");
        Assert.hasText(reposiFichaM.findByPaciente(paciente).getNombre(),"no se encuentr el nombre");
        Assertions.assertNotEquals(paci2,reposiFichaM.findByPaciente(paciente),"las fichas medicas coinciden");

    }
}