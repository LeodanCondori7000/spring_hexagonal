package com.semana7.hexagonal.infrastructure.config;

import com.semana7.hexagonal.application.service.PersonaService;
import com.semana7.hexagonal.application.usecase.PersonaServiceImpl;
import com.semana7.hexagonal.domain.ports.out.PersonaOut;
import com.semana7.hexagonal.infrastructure.repository.PersonaJPARepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public PersonaService personaService(PersonaOut personaOut){
        return new PersonaService((new PersonaServiceImpl(personaOut)));
    }
    @Bean
    public PersonaOut personaOut(PersonaJPARepositoryAdapter personaJPARepositoryAdapter){
        return personaJPARepositoryAdapter;
    }
}
