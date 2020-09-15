package com.ufro.dci.saludContigo.modelo;

import javax.persistence.*;
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
    private String rut;
    @Column(name = "correo")
    private String correo;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn( name="idEspecialidad", nullable = true)
    private Especialidad especialidad;
    @Column(name = "contraseña")
    private String contrasena;
    @OneToMany(fetch = FetchType.EAGER)
    private List<Paciente> pacientes;


    public Doctor(){

    }

    public Doctor(Long idDoctor, String nombre, String apellido, String rut, String correo, Especialidad especialidad, String contrasena, List<Paciente> pacientesta) {
        this.idDoctor = idDoctor;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.correo = correo;
        this.especialidad = especialidad;
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

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
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
                ", especialidad=" + especialidad +
                ", contraseña='" + contrasena + '\'' +
                ", pacientes=" + pacientes +
                '}';
    }


}
