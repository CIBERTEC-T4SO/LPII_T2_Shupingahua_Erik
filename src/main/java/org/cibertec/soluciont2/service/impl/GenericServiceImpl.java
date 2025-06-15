package org.cibertec.soluciont2.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.cibertec.soluciont2.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenericServiceImpl<T,ID> implements GenericService<T,ID> {


    protected  JpaRepository<T,ID> repository;


    @Override
    public Optional<T> buscarPorID(ID id) {
        return Optional.ofNullable(repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No se encontró entidad con ID: " + id)));
    }

    @Override
    public List<T> obtenerTodos() {
        return  repository.findAll();
    }

    @Override
    public void grabar(T entity) {
        repository.save(entity);
    }

    @Override
    public void eliminar(ID id) {
        repository.deleteById(id);
    }
}
