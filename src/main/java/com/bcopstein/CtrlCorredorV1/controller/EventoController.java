package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.EventoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {
    private final EventoRepository eventoRepository;

    public EventoController(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventoRepository.findAll();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return eventoRepository.saveEvento(evento);
    }

}
