package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Especialidad;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReposiEspecialidad extends CrudRepository<Especialidad,Long> {

}
