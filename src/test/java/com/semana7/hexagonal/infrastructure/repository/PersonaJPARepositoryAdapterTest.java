package com.semana7.hexagonal.infrastructure.repository;

import com.semana7.hexagonal.domain.model.Persona;
import com.semana7.hexagonal.infrastructure.entity.PersonaEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PersonaJPARepositoryAdapterTest {
    @Mock
    PersonaJPARepository personaJPARepository;
    @InjectMocks
    PersonaJPARepositoryAdapter personaJPARepositoryAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        personaJPARepositoryAdapter = new PersonaJPARepositoryAdapter(personaJPARepository);
    }
    @Test
    void createPersonaExitoso() {
        //PREPARAR
        Persona persona = new Persona(1L,"Leodan","Condori",new Date(),"Masculino");

        PersonaEntity personaEntity = new PersonaEntity(1L,"Leodan","Condori",new Date(),"Masculino");

        //SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.save(Mockito.any(PersonaEntity.class))).thenReturn(personaEntity);

        Persona personaAdapter = personaJPARepositoryAdapter.createPersona(persona);

        //AFIRMAR
        assertNotNull(personaAdapter);
        assertEquals(persona.getId(),personaAdapter.getId());
    }

    @Test
    void findById_IsEmpty() {
        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());

        Optional<Persona> result = personaJPARepositoryAdapter.getPersona(1L);

        // AFIRMAR
        assertTrue(result.isEmpty());
    }

    @Test
    void findById_ExistingId_ReturnsPersona() {
        // PREPARAR
        PersonaEntity personaEntity = new PersonaEntity(1L, "Leodan", "Condori", new Date(), "Masculino");

        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.findById(Mockito.anyLong())).thenReturn(Optional.of(personaEntity));

        Optional<Persona> result = personaJPARepositoryAdapter.getPersona(1L);

        // AFIRMAR
        assertTrue(result.isPresent());
        assertEquals(personaEntity.toDomainModel(), result.get());
    }

    @Test
    void update_ExistingIdAndValidPersona_ReturnsUpdatedPersona() {
        // PREPARAR
        Persona persona = new Persona(1L, "UpdatedLeodan", "UpdatedCondori", new Date(), "Masculino");
        PersonaEntity existingEntity = new PersonaEntity(1L, "Leodan", "Condori", new Date(), "Masculino");

        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.existsById(Mockito.anyLong())).thenReturn(true);
        Mockito.when(personaJPARepository.save(Mockito.any(PersonaEntity.class))).thenReturn(existingEntity);

        Optional<Persona> result = personaJPARepositoryAdapter.updatePersona(1L, persona);

        // AFIRMAR
        assertTrue(result.isPresent());
        assertEquals(existingEntity.toDomainModel(), result.get());
    }

    @Test
    void update_NonExistingId_ReturnsEmptyOptional() {
        // PREPARAR
        Persona persona = new Persona(1L, "UpdatedLeodan", "UpdatedCondori", new Date(), "Masculino");

        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.existsById(Mockito.anyLong())).thenReturn(false);

        Optional<Persona> result = personaJPARepositoryAdapter.updatePersona(1L, persona);

        // AFIRMAR
        assertTrue(result.isEmpty());
    }

    @Test
    void deleteById_NonExistingId_ReturnsFalse() {
        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.existsById(Mockito.anyLong())).thenReturn(false);

        boolean result = personaJPARepositoryAdapter.deletePersona(1L);

        // AFIRMAR
        assertFalse(result);
    }

    @Test
    void deleteById_ExistingId_ReturnsTrue() {
        // SIMULAR & EJECUTAR
        Mockito.when(personaJPARepository.existsById(Mockito.anyLong())).thenReturn(true);

        boolean result = personaJPARepositoryAdapter.deletePersona(1L);

        // AFIRMAR
        assertTrue(result);
    }

    @Test
    void getPersona() {
    }

    @Test
    void updatePersona() {
    }

    @Test
    void deletePersona() {
    }
}