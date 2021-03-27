package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.EventosRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estatisticas")
public class EstatisticasController {
    private EventosRepositoryImpl eventosRepository;

    public EstatisticasController(EventosRepositoryImpl eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    @GetMapping
    public EstatisticasDTO estatisticas(@RequestParam final int distancia) {
        var eventos = eventosRepository.findAll()
                .stream()
                .filter(e -> e.getDistancia() == distancia)
                .collect(Collectors.toList());

        eventos.sort(new Comparator<Evento>() {
            @Override
            public int compare(Evento e1, Evento e2) {
                return e1.getTempoEmMinutos() - e2.getTempoEmMinutos();
            }
        });

        var totalMinutos = 0;
        for (Evento e : eventos) {
            totalMinutos += e.getTempoEmMinutos();
        }

        var media = totalMinutos / eventos.size();
        var mediana = 0;

        if (eventos.size() % 2 == 0) {
            var soma = eventos.get(eventos.size() / 2).getTempoEmMinutos() + eventos.get((eventos.size() / 2) - 1).getTempoEmMinutos();
            mediana = soma / 2;
        } else {
            mediana = eventos.get(eventos.size() / 2).getTempoEmMinutos();
        }

        int tam = eventos.size();
        var desvPadrao = 0D;
        for (Evento e : eventos) {
            var aux = e.getTempoEmMinutos() - media;
            desvPadrao += aux * aux;
        }

        var desvioPadrao = Math.sqrt(desvPadrao / (tam - 1));

        var dto = new EstatisticasDTO(media, mediana, desvioPadrao, eventos.size());
        return dto;
    }
}
