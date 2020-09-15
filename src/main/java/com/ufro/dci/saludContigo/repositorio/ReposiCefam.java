package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Cesfam;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReposiCefam extends CrudRepository<Cesfam,Long> {

    Iterable<Cesfam> findByPacientes(Paciente paciente);

    Iterable<Cesfam>findByDoctores(Doctor doctor);
}
