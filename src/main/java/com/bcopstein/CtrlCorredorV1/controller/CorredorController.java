package com.bcopstein.CtrlCorredorV1.controller;

import java.util.List;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import com.bcopstein.CtrlCorredorV1.model.Evento;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepository;
import com.bcopstein.CtrlCorredorV1.repository.CorredorRepositoryImpl;
import com.sun.source.tree.ReturnTree;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
