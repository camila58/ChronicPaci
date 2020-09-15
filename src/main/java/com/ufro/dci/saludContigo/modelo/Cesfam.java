package com.ufro.dci.saludContigo.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cefam")
public class Cesfam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCefam;

    @Column(name = "nombre")
    private String nombre;
    @OneToMany(fetch =FetchType.LAZY)
    private List<Doctor>doctores;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Paciente>pacientes;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Sucursal>sucursal;

    public Cesfam(String nombre){

    }

    public Cesfam(Long idCefam, String nombre, List<Doctor> doctores, List<Paciente> pacientes, List<Sucursal> sucursal) {
        this.idCefam = idCefam;
        this.nombre = nombre;
        this.doctores = doctores;
        this.pacientes = pacientes;
        this.sucursal = sucursal;
    }

    public Long getIdCefam() {
        return idCefam;
    }

    public void setIdCefam(Long idCefam) {
        this.idCefam = idCefam;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public List<Sucursal> getSucursal() {
        return sucursal;
    }

    public void setSucursal(List<Sucursal> sucursal) {
        this.sucursal = sucursal;
    }

    @Override
    public String toString() {
        return "Cesfam{" +
                "idCefam=" + idCefam +
                ", nombre='" + nombre + '\'' +
                ", doctores=" + doctores +
                ", pacientes=" + pacientes +
                ", sucursal=" + sucursal +
                '}';
    }
}
