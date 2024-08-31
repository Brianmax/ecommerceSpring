package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.ProveedorEntity;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProveedorRepository extends JpaRepository<ProveedorEntity, Integer>{
	boolean existsByRucdni(String dni);
	Optional<ProveedorEntity> findByRazonsocial(String razonsocial);
}
