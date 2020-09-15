package com.ufro.dci.saludContigo.modelo;

import com.ufro.dci.saludContigo.modelo.enumeration.Enfermedades;
import com.ufro.dci.saludContigo.modelo.enumeration.GrupoSanginio;

import javax.persistence.*;

@Entity
@Table(name = "fichaMedica")
public class FichaMedica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFichaM;
    @Column(name = "nombre")
    private String nombre;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name="idPaciente", nullable = true)
    private Paciente paciente;
    @Column(name ="grupoSanginio")
    private GrupoSanginio grupoSanginio;
    @Column(name ="enfermedades")
    private Enfermedades enfermedades;
    @Column(name = "descripcion")
    private String descripcion;

    public FichaMedica(Long idFichaM, String nombre, Paciente paciente, GrupoSanginio grupoSanginio, Enfermedades enfermedades, String descripcion) {
        this.idFichaM = idFichaM;
        this.nombre = nombre;
        this.paciente = paciente;
        this.grupoSanginio = grupoSanginio;
        this.enfermedades = enfermedades;
        this.descripcion = descripcion;
    }

    public FichaMedica(){

    }

    public Long getIdFichaM() {
        return idFichaM;
    }

    public void setIdFichaM(Long idFichaM) {
        this.idFichaM = idFichaM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public GrupoSanginio getGrupoSanginio() {
        return grupoSanginio;
    }

    public void setGrupoSanginio(GrupoSanginio grupoSanginio) {
        this.grupoSanginio = grupoSanginio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Enfermedades getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(Enfermedades enfermedades) {
        this.enfermedades = enfermedades;
    }

    @Override
    public String toString() {
        return "FichaMedica{" +
                "idFichaM=" + idFichaM +
                ", nombre='" + nombre + '\'' +
                ", paciente=" + paciente +
                ", grupoSanginio=" + grupoSanginio +
                ", enfermedades=" + enfermedades +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
