package com.ufro.dci.saludContigo.modelo.enumeration;

public enum TipoEspecialidades {
    GINECOLOGIA("ginecología"),TRAUMATOLOGÍA("traumatología"),UROLOGIA("urología"),DERMATOLOGIA("dermatologia"),ANGIOLOGIA("angeología");

    private final String tipo;

    TipoEspecialidades(String tipo){
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
