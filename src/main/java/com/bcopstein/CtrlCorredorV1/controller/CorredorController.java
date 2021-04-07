package com.bcopstein.CtrlCorredorV1.controller;

import com.bcopstein.CtrlCorredorV1.dados.model.Corredor;
import com.bcopstein.CtrlCorredorV1.service.CorredorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corredores")
public class CorredorController {
    private final CorredorService corredorService;

    public CorredorController(CorredorService corredorService) {
        this.corredorService = corredorService;
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorService.consultaCorredor();
    }

    @PostMapping
    @CrossOrigin(origins = "*")
    public boolean cadastraCorredor(@RequestBody final Corredor corredor) {
        return corredorService.cadastraCorredor(corredor);
    }

}
