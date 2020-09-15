package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Horario;
import org.springframework.data.repository.CrudRepository;

import javax.print.Doc;
import java.util.List;

public interface ReposiDoctor extends CrudRepository<Doctor,Long> {
   @Override
   public List<Doctor>findAll();

   public  Doctor findByCorreoAndContrasena(String correo, String clave);

   public Doctor findByCorreo(String correo);



}
