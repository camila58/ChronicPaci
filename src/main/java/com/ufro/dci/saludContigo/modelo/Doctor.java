package com.ufro.dci.saludContigo.modelo;

import com.ufro.dci.saludContigo.modelo.enumeration.TipoCefam;
import com.ufro.dci.saludContigo.modelo.enumeration.TipoEspecialidades;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDoctor;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "rut")
    @Pattern(regexp = "^\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}$")
    private String rut;
    @Column(name = "correo")
    private String correo;
    @Column(name = "tipoEspecialidad")
    private TipoEspecialidades tipoEspecialidades;
    @ManyToOne
    private Cesfam cesfam;
    @Column(name = "contraseña")
    private String contrasena;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Paciente> pacientes;


    public Doctor(){

    }

    public Doctor(Long idDoctor, String nombre, String apellido, String rut, String correo, TipoEspecialidades tipoEspecialidades, Cesfam cesfam, String contrasena, List<Paciente> pacientes) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.tipoEspecialidades = tipoEspecialidades;
        this.cesfam = cesfam;
        this.contrasena = contrasena;
        this.pacientes = pacientes;
    }

    public Long getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Long idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public TipoEspecialidades getTipoEspecialidades() {
        return tipoEspecialidades;
    }

    public void setTipoEspecialidades(TipoEspecialidades tipoEspecialidades) {
        this.tipoEspecialidades = tipoEspecialidades;
    }

    public Cesfam getCesfam() {
        return cesfam;
    }

    public void setCesfam(Cesfam cesfam) {
        this.cesfam = cesfam;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "idDoctor=" + idDoctor +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", tipoEspecialidades=" + tipoEspecialidades +
                ", cesfam=" + cesfam +
                ", contrasena='" + contrasena + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }
}
