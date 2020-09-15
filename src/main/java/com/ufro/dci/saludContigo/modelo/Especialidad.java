package com.ufro.dci.saludContigo.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tipoEspecialidad")
public class Especialidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoEspec;

    @Column(name = "nombre")
    private String nombre;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Doctor>doctors;

    public Especialidad(Long idTipoEspec, String nombre, List<Doctor> doctors) {
        this.idTipoEspec = idTipoEspec;
        this.nombre = nombre;
        this.doctors = doctors;
    }

    public Especialidad(String nombre) {
    }

    public Long getIdTipoEspec() {
        return idTipoEspec;
    }

    public void setIdTipoEspec(Long idTipoEspec) {
        this.idTipoEspec = idTipoEspec;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "Especialidad{" +
                "idTipoEspec=" + idTipoEspec +
                ", nombre='" + nombre + '\'' +
                ", doctors=" + doctors +
                '}';
    }
}
