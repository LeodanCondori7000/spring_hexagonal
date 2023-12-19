package com.semana7.hexagonal.domain.ports.in;

import com.semana7.hexagonal.domain.model.Persona;

import java.util.Optional;

public interface PersonaIn {
    Persona crearPersona(Persona persona);
    Optional<Persona> getPersona(Long id);
    Optional<Persona> actualizaPersona(Long id, Persona persona);
    boolean borrarPersona(Long id);
}
