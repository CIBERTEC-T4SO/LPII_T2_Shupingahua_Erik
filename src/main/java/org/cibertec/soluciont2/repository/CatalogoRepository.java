package org.cibertec.soluciont2.repository;

import org.cibertec.soluciont2.entity.Catalogo;
import org.cibertec.soluciont2.entity.PedidoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CatalogoRepository extends JpaRepository<Catalogo, Integer> {
    Optional<Catalogo> findByCodigo(String codigo);
}
