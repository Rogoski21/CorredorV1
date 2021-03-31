package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.dto.EstatisticasDTO;
import com.bcopstein.CtrlCorredorV1.dto.PerformanceDTO;
import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class EstatisticasService {
    private final EventoRepositoryImpl eventosRepository;

    public EstatisticasService(EventoRepositoryImpl eventosRepository) {
        this.eventosRepository = eventosRepository;
    }

    public EstatisticasDTO getEstatisticasDTO(int distancia) {
        var eventos = eventosRepository.findAll()
                .stream()
                .filter(e -> e.getDistancia() == distancia)
                .sorted(Comparator.comparingInt(Evento::getTempoEmMinutos))
                .collect(Collectors.toList());

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

    public PerformanceDTO getPerformanceDTO(int distancia, int ano) {
        var eventos = eventosRepository.findAll()
                .stream()
                .filter(e -> e.getAno() == ano)
                .filter(e -> e.getDistancia() == distancia)
                .sorted((e1, e2) -> {
                    var d1 = e1.getAno() * 365 + e1.getMes() * 30 + e1.getDia();
                    var d2 = e2.getAno() * 365 + e2.getMes() * 30 + e2.getDia();
                    return d1 - d2;
                })
                .collect(Collectors.toList());

        var maiorDiff = -1;
        var eventosDiferença = new Evento[2];
        for (int i = 0; i < eventos.size() - 1; i++) {
            var atual = eventos.get(i);
            var prox = eventos.get(i + 1);

            var diff = atual.getTempoEmMinutos() - prox.getTempoEmMinutos();
            if (diff > maiorDiff) {
                maiorDiff = diff;
                eventosDiferença[0] = atual;
                eventosDiferença[1] = prox;
            }
        }

        var dto = new PerformanceDTO(eventosDiferença[0].getNome(), eventosDiferença[1].getNome());
        return dto;
    }
}
