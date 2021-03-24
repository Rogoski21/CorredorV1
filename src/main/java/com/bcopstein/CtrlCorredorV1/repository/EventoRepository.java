package com.bcopstein.CtrlCorredorV1.repository;

import com.bcopstein.CtrlCorredorV1.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventoRepository {
    List<Evento> findAll();
    Boolean saveEvento(Evento evento);
}
