package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Integer> {
}
