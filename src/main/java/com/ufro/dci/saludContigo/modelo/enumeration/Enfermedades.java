package com.ufro.dci.saludContigo.modelo.enumeration;

public enum Enfermedades {
    CANCER("cáncer"),ARTITRIS("artritis"),HIPERTENSION("hipertensión"),TRASTORNOBIPOLAR("trastorno bipolar"),ENFERMEDADCROHN("enfermedad de crohn"),EPILEPSIA("epilepsia"),ENFERMEDADPARKINSON("enfermedad de parkinson"),ESCLEROSISMULTIPLE("esclerosis múltiple"),DEMENCIA("demencia"),VIH("vih"),APNEADELSUEÑO("apnea del sueño"),ALZHEIMER("alzheimer"),ANSIEDAD("ansiedad"),TIROIDES("tiroides"),LUMBALGIA("lumbalgia"),DEPRESION("depresión"),OSTEOPOROSIS("osteoporosis"),HEMOFILIA("hemofilia"),FIBROSISQUISTICA("fibrosis quística");
    private final String tipoE;
    Enfermedades(String tipoE){
        this.tipoE=tipoE;
    }
    public String getTipoE(){
        return tipoE;
    }

}

