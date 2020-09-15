package com.ufro.dci.saludContigo.modelo.enumeration;

public enum GrupoSanginio {
    GRUPOA(" grupo A"),GRUPOB("grupo B"),GRUPOAB("grupo AB"),GRUPO0("grupo 0");

    private final String tipo;

    GrupoSanginio(String tipo){
        this.tipo=tipo;
    }
    public String getTipo(){
        return tipo;
    }
}
