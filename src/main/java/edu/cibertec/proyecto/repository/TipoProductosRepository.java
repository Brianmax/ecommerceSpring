package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.TipoProductoEntity;
@Repository
public interface TipoProductosRepository extends JpaRepository<TipoProductoEntity, Integer> {

}
