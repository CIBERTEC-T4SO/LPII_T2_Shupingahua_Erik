package org.cibertec.soluciont2.service.impl;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.cibertec.soluciont2.entity.Catalogo;
import org.cibertec.soluciont2.entity.CatalogoValor;
import org.cibertec.soluciont2.repository.CatalogoRepository;
import org.cibertec.soluciont2.repository.CatalogoValorRepository;
import org.cibertec.soluciont2.service.CatalogoService;
import org.cibertec.soluciont2.service.CatalogoValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CatalogValorServiceImpl extends GenericServiceImpl<CatalogoValor, Integer> implements CatalogoValorService {

    @Autowired
    private CatalogoValorRepository repository;

    @PostConstruct
    private void init() {
        super.repository = repository;
    }

    @Override
    public Optional<CatalogoValor> obtenerPorCodigo(String codigo) {
        //return Optional.empty();
        return Optional.ofNullable(repository.findByCodigo(codigo)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró entidad con Código: " + codigo)));
    }



}