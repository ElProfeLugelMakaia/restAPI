package com.example.holaMundo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController()
@RequestMapping("api/v1/personas2")
public class TransitoController {

    PersonaServicio service;
    @Autowired()
    public TransitoController(PersonaServicio service){
        this.service = service;

    }
    @GetMapping()
    public ArrayList<Persona> listarPersonas(){
        return this.service.listarPersonas();
    }
}
