package com.semana7.hexagonal.application.usecase;

import com.semana7.hexagonal.domain.model.Persona;
import com.semana7.hexagonal.domain.ports.out.PersonaOut;
import com.semana7.hexagonal.domain.ports.in.PersonaIn;

import java.util.Optional;

public class PersonaServiceImpl implements PersonaIn{
    private final PersonaOut personaOut;
    public PersonaServiceImpl(PersonaOut personaOut){
        this.personaOut = personaOut;
    }
    @Override
    public Persona crearPersona(Persona persona) {
        return personaOut.createPersona(persona);
    }

    @Override
    public Optional<Persona> getPersona(Long id) {
        return personaOut.getPersona(id);
    }

    @Override
    public Optional<Persona> actualizaPersona(Long id, Persona persona) {
        return personaOut.updatePersona(id,persona);
    }

    @Override
    public boolean borrarPersona(Long id) {
        return personaOut.deletePersona(id);
    }
}
