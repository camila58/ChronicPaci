package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.repository.CrudRepository;


public interface ReposiBlocNota extends CrudRepository<BlocNota,Long> {

    Iterable<BlocNota> findByPaciente(Paciente paciente);

    Iterable<BlocNota>findByDoctor(Doctor doctor);
}
