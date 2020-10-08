package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.FichaMedica;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ReposiFichaM extends CrudRepository<FichaMedica,Long> {

    FichaMedica findByPaciente(Paciente paciente);

}
