package com.ufro.dci.saludContigo.repositorio;

import com.ufro.dci.saludContigo.modelo.BlocNota;
import com.ufro.dci.saludContigo.modelo.Doctor;
import com.ufro.dci.saludContigo.modelo.Horario;
import com.ufro.dci.saludContigo.modelo.Paciente;
import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReposiHorario extends CrudRepository<Horario,Long> {
    Horario findByPeriodoAndDia(Periodo periodoByNum, Dia diaByNum);

    Iterable<Horario> findByPaciente(Paciente paciente);

    Iterable<Horario>findByDoctor(Doctor doctor);


}
