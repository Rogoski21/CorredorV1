package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final EventoRepository eventoRepository;

    public EventoService(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> consultaEventos() {
        return eventoRepository.findAll();
    }

    public boolean informaEvento(Evento evento) {
        return eventoRepository.saveEvento(evento);
    }

}
