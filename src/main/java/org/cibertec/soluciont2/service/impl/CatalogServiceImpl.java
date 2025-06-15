package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.cibertec.soluciont2.entity.*;
import org.cibertec.soluciont2.repository.CatalogoRepository;
import org.cibertec.soluciont2.service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogServiceImpl extends GenericServiceImpl<Catalogo, Integer> implements CatalogoService {

    @Autowired
    private CatalogoRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }

    @Override
    public Optional<Catalogo> obtenerPorCodigo(String codigo) {
        //return Optional.empty();
        return Optional.ofNullable(repository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró entidad con Código: " + codigo)));
    }



}