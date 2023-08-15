package com.example.holaMundo;

import com.example.holaMundo.exceptions.ApiRequestExeption;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PersonaServicioTest {

    PersonaServicio servicio;
    List<Persona> personas;

    @BeforeEach
    public void init(){
        personas = new ArrayList<>();
        servicio = new PersonaServicio(personas);
    }

    @Test
    public void agregaPersonaEnLaListaExitosamente() {
        // Arrange
        Persona persona = new Persona("Lugel", "1152", "Franco", "Paisalandia");
        Assertions.assertEquals(0, personas.size());

        // Act
        servicio.crearPersona(persona);

        // Assert
        Assertions.assertEquals(1, personas.size());
    }

    @Test()
    public void fallaLaCreacionDePersonaCuandoNombreEsNulo(){
        // Arrange
        Persona persona = new Persona();

        // Assert
        Assertions.assertThrows(ApiRequestExeption.class, () -> {
            // Act
            servicio.crearPersona(persona);
        });
    }

    @Test()
    public void ElNombreDeLaPersonaCambiaCuandoEnActualizarPersona(){
        // TODO: Add unit Test
    }

    // TODO: Agregar dos pruebas unitarias por cada método mínimo. 1 correcta, y 1 fallo.
}
