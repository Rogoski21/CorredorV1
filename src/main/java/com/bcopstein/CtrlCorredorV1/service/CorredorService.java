package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.dados.model.Corredor;
import com.bcopstein.CtrlCorredorV1.dados.repository.ICorredorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorredorService {

    private ICorredorRepository corredorRepository;


    public CorredorService(ICorredorRepository corredorRepository) {
        this.corredorRepository = corredorRepository;
    }

    public List<Corredor> consultaCorredor() {
        return corredorRepository.findAll();
    }

    public boolean cadastraCorredor(Corredor corredor) {
        return corredorRepository.saveCorredor(corredor);
    }


}
