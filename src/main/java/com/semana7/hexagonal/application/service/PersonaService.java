package com.semana7.hexagonal.application.service;

import com.semana7.hexagonal.domain.model.Persona;
import com.semana7.hexagonal.domain.ports.in.PersonaIn;

import java.util.Optional;

public class PersonaService implements PersonaIn {
    private final PersonaIn personaIn;
    public PersonaService(PersonaIn personaIn){
        this.personaIn = personaIn;
    }
    @Override
    public Persona crearPersona(Persona persona) {
        return this.personaIn.crearPersona(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaIn.getPersona(id);
    }

    @Override
    public Optional<Persona> actualizaPersona(Long id, Persona persona) {
        return personaIn.actualizaPersona(id,persona);
    }

    @Override
    public boolean borrarPersona(Long id) {
        return personaIn.borrarPersona(id);
    }
}
