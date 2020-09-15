package com.ufro.dci.saludContigo.modelo.enumeration;

public enum TipoCefam {
    CESFAMELCARMEN("cesfam el carmen"),CESFAMAMANECER("cesfam amanecer"),CEFAMVILLAALEGRE("cefam villa alegre"),CEFAM("cesfam pedro de valdivia");

    private final String tipo;

    TipoCefam(String tipo){
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
