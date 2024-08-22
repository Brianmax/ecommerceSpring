package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.TipoProductoEntity;
@Repository
public interface TipoProductoRepository extends JpaRepository<TipoProductoEntity, Integer> {
    boolean existsByNombre(String nombre);
}
