package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryEntity, Integer> {
}
