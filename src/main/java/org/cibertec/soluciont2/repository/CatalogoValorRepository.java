package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.Catalogo;
import org.cibertec.soluciont2.entity.CatalogoValor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogoValorRepository extends JpaRepository<CatalogoValor, Integer> {
    Optional<CatalogoValor> findByCodigo(String codigo);
}
