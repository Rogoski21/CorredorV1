package com.bcopstein.CtrlCorredorV1.repository;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import com.bcopstein.CtrlCorredorV1.model.Evento;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorredorRepository {
    List<Corredor> findAll();
    boolean saveCorredor(Corredor corredor);

}
