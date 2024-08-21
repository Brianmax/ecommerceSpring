package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.OperacionEntity;
import java.util.List;
import edu.cibertec.proyecto.entity.ProductoEntity;

@Repository
public interface OperacionesRepository extends JpaRepository<OperacionEntity, Integer>{
	
	List<OperacionEntity> findByProducto(ProductoEntity producto);
	
}
