package edu.cibertec.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.cibertec.proyecto.entity.UsuarioEntity;
import java.util.List;


public interface UsuariosRepository extends JpaRepository<UsuarioEntity, Integer>{
}
