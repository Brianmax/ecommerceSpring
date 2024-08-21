package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.VentaEntity;
@Repository
public interface VentasRepository extends JpaRepository<VentaEntity, String>{

}
