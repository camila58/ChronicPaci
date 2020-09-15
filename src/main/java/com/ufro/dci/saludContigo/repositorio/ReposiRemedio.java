package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.Remedio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReposiRemedio extends CrudRepository<Remedio,Long> {


}
