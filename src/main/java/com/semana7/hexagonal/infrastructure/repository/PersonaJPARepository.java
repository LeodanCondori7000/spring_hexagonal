package com.semana7.hexagonal.infrastructure.repository;

import com.semana7.hexagonal.infrastructure.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaJPARepository extends JpaRepository<PersonaEntity,Long> {
}
