package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.dto.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepositoryImpl;
import com.bcopstein.CtrlCorredorV1.service.EstatisticasService;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {
    private final EstatisticasService estatisticasService;

    public EstatisticasController(EstatisticasService estatisticasService) {
        this.estatisticasService = estatisticasService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public EstatisticasDTO estatisticas(@RequestParam final int distancia) {
        return estatisticasService.getEstatisticasDTO(distancia);
    }

    @GetMapping("/aumento-performance")
    @CrossOrigin(origins = "*")
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia,
                                             @RequestParam final int ano) {
        return estatisticasService.getPerformanceDTO(distancia, ano);
    }
}