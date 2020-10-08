package com.ufro.dci.saludContigo.modelo;

import com.ufro.dci.saludContigo.modelo.enumeration.TipoCefam;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPaciente;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Pattern(regexp = "^\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}$")
    @Column(name = "rut")
    private String rut;
    @Column(name = "correo")
    private String correo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idDoctor", nullable = true)
    private Doctor doctor;
    @ManyToOne
    private Cesfam cesfam;
    @Column(name = "contraseña")
    private String contrasena;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String nombre, String apellido, @Pattern(regexp = "^\\d{1,2}\\.\\d{3}\\.\\d{3}[-][0-9kK]{1}$") String rut, String correo, Doctor doctor, Cesfam cesfam, String contrasena) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.doctor = doctor;
        this.cesfam = cesfam;
        this.contrasena = contrasena;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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

    @Override
    public String toString() {
        return "Paciente{" +
                "idPaciente=" + idPaciente +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", rut='" + rut + '\'' +
                ", correo='" + correo + '\'' +
                ", doctor=" + doctor +
                ", cesfam=" + cesfam +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
