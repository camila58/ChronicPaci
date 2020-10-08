package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface ReposiPacien extends CrudRepository<Paciente,Long> {

    public Paciente findByCorreoAndContrasena(String correo, String contrasena);

    public Paciente findByCorreo(String correo);

    public Paciente findByContrasena(String contrasena);

}
