package com.ufro.dci.saludContigo.modelo.enumeration;

public enum Dia {
    LUNES("lunes"),MARTES("martes"),MIERCOLES("miercoles"),
    JUEVES("jueves"),VIERNES("viernes"),SABADO("sabado"),
    DOMINGO("domingo");
    private final String diaFinal;
    Dia(String diaFinal) {
        this.diaFinal=diaFinal;
    }

    public String getDiaFinal() {
        return diaFinal;
    }

    public static Dia getDiaByNum(int num){
        switch (num){
            case 0:
                return Dia.LUNES;
            case 1:return Dia.MARTES;

            case 2:return Dia.MIERCOLES;
            case 3:return Dia.JUEVES;
            case 4:return Dia.VIERNES;
            case 5:return Dia.SABADO;
            case 6:return Dia.DOMINGO;
        }
        return null;
    }
}
