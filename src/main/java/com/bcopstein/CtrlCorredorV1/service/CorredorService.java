package com.bcopstein.CtrlCorredorV1.service;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorredorService {

    private CorredorRepository corredorRepository;


    public CorredorService(CorredorRepository corredorRepository) {
        this.corredorRepository = corredorRepository;
    }

    public List<Corredor> consultaCorredor() {
        return corredorRepository.findAll();
    }

    public boolean cadastraCorredor(Corredor corredor) {
        return corredorRepository.saveCorredor(corredor);
    }


}
