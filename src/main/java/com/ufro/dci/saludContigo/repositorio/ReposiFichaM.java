package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReposiFichaM extends CrudRepository<FichaMedica,Long> {
    Iterable<FichaMedica> findByPaciente(Paciente paciente);
}
