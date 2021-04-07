package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.dados.model.Evento;
import com.bcopstein.CtrlCorredorV1.service.EventoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    private EventoService eventosService;


    public EventoController(EventoService eventosService) {
        this.eventosService = eventosService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventosService.consultaEventos();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return eventosService.informaEvento(evento);
    }

}
