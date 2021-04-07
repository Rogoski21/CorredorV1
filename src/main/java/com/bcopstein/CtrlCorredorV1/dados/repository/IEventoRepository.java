package com.bcopstein.CtrlCorredorV1.dados.repository;

import com.bcopstein.CtrlCorredorV1.dados.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface IEventoRepository {
    List<Evento> findAll();
    Boolean saveEvento(Evento evento);
}
