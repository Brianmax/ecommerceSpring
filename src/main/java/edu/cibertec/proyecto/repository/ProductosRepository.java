package edu.cibertec.proyecto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.ProductoEntity;

@Repository
public interface ProductosRepository extends JpaRepository<ProductoEntity, Integer>{
	
	List<ProductoEntity> findByEstado(int estado);
	
	
}
