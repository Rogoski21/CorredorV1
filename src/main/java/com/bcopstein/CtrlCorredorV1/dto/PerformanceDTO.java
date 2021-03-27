package com.bcopstein.CtrlCorredorV1.dto;

public class PerformanceDTO {
    private String[] eventos;

    public PerformanceDTO(String[] eventos) {
        this.eventos = eventos;
    }

    public String[] getEventos() {
        return eventos;
    }
}
