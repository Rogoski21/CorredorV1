package com.bcopstein.CtrlCorredorV1.dados.repository;

import com.bcopstein.CtrlCorredorV1.dados.model.Corredor;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ICorredorRepository {
    List<Corredor> findAll();
    boolean saveCorredor(Corredor corredor);

}
