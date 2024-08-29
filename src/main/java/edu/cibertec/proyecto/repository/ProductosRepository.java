package edu.cibertec.proyecto.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.ProductoEntity;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Integer>{
	
	List<ProductoEntity> findByEstado(boolean estado, Pageable pageable);
	List<ProductoEntity> findByEstado(boolean estado);
	Optional<ProductoEntity> findByNombre(String nombre);
}
