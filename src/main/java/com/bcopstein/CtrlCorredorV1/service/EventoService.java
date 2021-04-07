package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.dados.model.Evento;
import com.bcopstein.CtrlCorredorV1.dados.repository.IEventoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoService {
    private final IEventoRepository eventoRepository;

    public EventoService(IEventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    public List<Evento> consultaEventos() {
        return eventoRepository.findAll();
    }

    public boolean informaEvento(Evento evento) {
        return eventoRepository.saveEvento(evento);
    }

}
