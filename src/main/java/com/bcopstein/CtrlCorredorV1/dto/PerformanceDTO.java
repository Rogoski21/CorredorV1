package com.bcopstein.CtrlCorredorV1.dto;

public class PerformanceDTO {
    private String evento1;
    private String evento2;

    public PerformanceDTO(String evento1, String evento2) {
        this.evento1 = evento1;
        this.evento2 = evento2;
    }

    public String getEvento1() {
        return evento1;
    }

    public String getEvento2() {
        return evento2;
    }
}
