package com.ufro.dci.saludContigo.modelo;

import javax.persistence.*;

@Entity
@Table(name = "sucursal")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSucursal;
    @Column(name = "direccion")
    private String direccion;

    public Sucursal(String direccion) {
        this.direccion = direccion;
    }

    public Sucursal(){

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "direccion='" + direccion + '\'' +
                '}';
    }
}
