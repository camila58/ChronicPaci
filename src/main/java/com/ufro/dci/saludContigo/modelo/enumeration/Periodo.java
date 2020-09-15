package com.ufro.dci.saludContigo.modelo.enumeration;

public enum Periodo {
    UNO("NO"),
    DOS("OO"),
    TRES("OF"),
    CUATRO("FS"),
    CINCO("SN"),
    SEIS("NE"),
    SIETE("NI"),
    OCHO("NT");

    private final String periodoFinal;
    Periodo(String periodoFinal) {
        this.periodoFinal=periodoFinal;
    }
    public String getDiaFinal() {
        return periodoFinal;
    }

    public static Periodo getPeriodoByNum(int num){
        switch (num){
            case 0:return Periodo.UNO;
            case 1:return Periodo.DOS;
            case 2:return Periodo.TRES;
            case 3:return Periodo.CUATRO;
            case 4:return Periodo.CINCO;
            case 5:return Periodo.SEIS;
            case 6:return Periodo.SIETE;
            case 7:return Periodo.OCHO;
        }
        return null;
    }
}
