package com.example.holaMundo;

import exceptions.ApiRequestExeption;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service()
public class PersonaServicio {
    ArrayList<Persona> personas;

    public PersonaServicio() {
        this.personas = new ArrayList<>();
    }

    public ArrayList<Persona> listarPersonas(){
        return this.personas;
    }

    public ArrayList<Persona> filtrarPersonas(String ciudad){
        return (ArrayList<Persona>) this.personas.stream().filter(p -> p.getCiudad().equals(ciudad)).collect(Collectors.toList());
    }

    public Optional<Persona> obtenerPersonaPorCedula(String cedula){
        return this.personas
                .stream()
                .filter(p-> p.getDocumento().equals(cedula))
                .findFirst();
    }

    public String obtenerNombrePorCedula(String cedula){
        Optional<Persona> persona = this.personas
                .stream()
                .filter(p-> p.getDocumento().equals(cedula))
                .findFirst();
        if(persona.isEmpty()) {
            throw new ApiRequestExeption("No se encontró la persona", null);
        }
        return persona.getNombre();
    }

    public Persona crearPersona(Persona persona){
        this.personas.add(persona);
        return persona;
    }

    public boolean actualizarPersona(Persona persona){
        Optional<Persona> existePersona = this.obtenerPersonaPorCedula(persona.getDocumento());
        if(existePersona.isPresent()){
            Persona personaAModificar = existePersona.get();
            personaAModificar.setNombre(persona.getNombre());
            personaAModificar.setApellido(persona.getApellido());
            personaAModificar.setCiudad(persona.getCiudad());
            personaAModificar.setDocumento(persona.getDocumento());
            return true;
        }
        return false;
    }

    public boolean eliminarPersona(String cedula){
        Optional<Persona> existePersona = this.obtenerPersonaPorCedula(cedula);
        if(existePersona.isPresent()) {
            this.personas.remove(existePersona.get());
        }
        return false;
    }
}
