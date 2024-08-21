package edu.cibertec.proyecto.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.cibertec.proyecto.entity.NumbersEntity;

@Repository
public interface NumbersRepository extends JpaRepository<NumbersEntity,Integer> {

}
