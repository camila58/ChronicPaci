package com.ufro.dci.saludContigo.modelo;

import javax.persistence.*;


@Entity
@Table(name = "blocNota")
public class BlocNota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBlocNota;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idDoctor", nullable = true)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPaciente", nullable = true)
    private Paciente paciente;

    @Column(name = "texto")
    private String texto;

    public BlocNota(long idBlocNota, Doctor doctor, Paciente paciente, String texto) {
        this.idBlocNota = idBlocNota;
        this.doctor = doctor;
        this.paciente = paciente;
        this.texto = texto;
    }

    public BlocNota() {
    }

    public long getIdBlocNota() {
        return idBlocNota;
    }

    public void setIdBlocNota(long idBlocNota) {
        this.idBlocNota = idBlocNota;
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

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return "BlocNota{" +
                "idBlocNota=" + idBlocNota +
                ", doctor=" + doctor +
                ", paciente=" + paciente +
                ", texto='" + texto + '\'' +
                '}';
    }
}
