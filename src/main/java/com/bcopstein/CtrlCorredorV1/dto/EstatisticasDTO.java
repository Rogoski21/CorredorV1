package com.bcopstein.CtrlCorredorV1.dto;

public class EstatisticasDTO {
    private double media;
    private double mediana;
    private double desvioPadrao;
    private int numCorridas;

    public EstatisticasDTO(double media, double mediana, double desvioPadrao, int numCorridas) {
        this.media = media;
        this.mediana = mediana;
        this.desvioPadrao = desvioPadrao;
        this.numCorridas = numCorridas;
    }

    public double getMedia() {
        return media;
    }

    public double getMediana() {
        return mediana;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }
}
