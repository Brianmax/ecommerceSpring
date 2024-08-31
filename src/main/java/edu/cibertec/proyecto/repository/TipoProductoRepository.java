package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.TipoProductoEntity;

import java.util.Optional;

@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity, Integer> {
    Optional<TipoProductoEntity> findByDescripcion(String descripcion);
}
