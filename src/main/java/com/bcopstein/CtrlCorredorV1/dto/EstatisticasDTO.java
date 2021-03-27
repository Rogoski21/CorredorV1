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

    public void setMedia(double media) {
        this.media = media;
    }

    public double getMediana() {
        return mediana;
    }

    public void setMediana(double mediana) {
        this.mediana = mediana;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public void setDesvioPadrao(double desvioPadrao) {
        this.desvioPadrao = desvioPadrao;
    }

    public int getNumCorridas() {
        return numCorridas;
    }

    public void setNumCorridas(int numCorridas) {
        this.numCorridas = numCorridas;
    }
}
