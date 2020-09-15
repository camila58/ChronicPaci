package com.ufro.dci.saludContigo.modelo;

import com.ufro.dci.saludContigo.modelo.enumeration.Dia;
import com.ufro.dci.saludContigo.modelo.enumeration.Periodo;

import javax.persistence.*;

@Entity
@Table(name = "horario")
public class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idHorario;

    @Column(name ="dia")
    private Dia dia;

    @Column(name="periodo")
    private Periodo periodo;

    @ManyToOne
    @JoinColumn(name = "idDoctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "idPaciente")
    private Paciente paciente;

    public Horario(Long idHorario, Dia dia, Periodo periodo, Doctor doctor, Paciente paciente) {
        this.idHorario = idHorario;
        this.dia = dia;
        this.periodo = periodo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    public Horario(){

    }

    public Long getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Long idHorario) {
        this.idHorario = idHorario;
    }

    public Dia getDia() {
        return dia;
    }

    public void setDia(Dia dia) {
        this.dia = dia;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public String toString() {
        return "Horario{" +
                "idHorario=" + idHorario +
                ", dia=" + dia +
                ", periodo=" + periodo +
                ", doctor=" + doctor +
                ", paciente=" + paciente +
                '}';
    }

}
