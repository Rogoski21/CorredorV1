package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corredores")
public class CorredorController {

    private CorredorRepository corredorRepository;

    public CorredorController(CorredorRepository corredorRepository) {
        this.corredorRepository = corredorRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorRepository.findAll();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        return corredorRepository.saveCorredor(corredor);
    }

}
