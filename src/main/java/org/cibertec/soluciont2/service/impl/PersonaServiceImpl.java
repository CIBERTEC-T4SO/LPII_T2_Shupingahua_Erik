package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import org.cibertec.soluciont2.entity.PersonaEntity;
import org.cibertec.soluciont2.repository.PersonaRepository;
import org.cibertec.soluciont2.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<PersonaEntity, Integer> implements PersonaService {

    @Autowired
    private PersonaRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }
}
