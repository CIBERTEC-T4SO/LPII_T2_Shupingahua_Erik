package org.cibertec.soluciont2.service.impl;

import org.cibertec.soluciont2.entity.CountryEntity;
import org.cibertec.soluciont2.repository.CountryRepository;
import org.cibertec.soluciont2.service.CountryService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends GenericServiceImpl<CountryEntity, Integer> implements CountryService {
    public CountryServiceImpl(JpaRepository<CountryEntity, Integer> repository) {
      this.repository = repository;
    }



}
