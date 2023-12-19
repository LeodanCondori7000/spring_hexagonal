package com.semana7.hexagonal.domain.ports.out;

import com.semana7.hexagonal.domain.model.Persona;

import java.util.Optional;

public interface PersonaOut {
    Persona createPersona(Persona persona);
    Optional<Persona> getPersona(Long id);
    Optional<Persona> updatePersona(Long id,Persona persona);
    boolean deletePersona(Long id);
}
