package edu.cibertec.proyecto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.ClienteEntity;

@Repository
public interface ClientesRepository extends JpaRepository<ClienteEntity,Integer>{

	Page<ClienteEntity> findByEstado(int estado, Pageable pageable);
	boolean existsByRucdni(String rucdni);
}
