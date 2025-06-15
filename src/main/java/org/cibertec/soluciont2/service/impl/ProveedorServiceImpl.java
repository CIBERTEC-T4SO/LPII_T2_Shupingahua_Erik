package org.cibertec.soluciont2.service.impl;

import org.cibertec.soluciont2.entity.CountryEntity;
import org.cibertec.soluciont2.entity.ProveedorEntity;
import org.cibertec.soluciont2.repository.CountryRepository;
import org.cibertec.soluciont2.repository.ProveedorRepository;
import org.cibertec.soluciont2.service.CountryService;
import org.cibertec.soluciont2.service.ProveedorService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProveedorServiceImpl extends GenericServiceImpl<ProveedorEntity, Integer> implements ProveedorService {
    public ProveedorServiceImpl(JpaRepository<ProveedorEntity, Integer> repository) {
        this.repository = repository;
    }

}
