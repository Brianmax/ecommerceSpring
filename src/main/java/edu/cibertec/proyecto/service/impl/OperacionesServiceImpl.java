package edu.cibertec.proyecto.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cibertec.proyecto.entity.OperacionEntity;
import edu.cibertec.proyecto.repository.OperacionesRepository;
import edu.cibertec.proyecto.service.OperacionesService;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OperacionesServiceImpl implements OperacionesService {
	OperacionesRepository ro;
	
	@Override
	public OperacionEntity crearOperaciones(OperacionEntity obj) {
		return ro.save(obj);
	}

	@Override
	public List<OperacionEntity> crearMultiplesOperaciones(List<OperacionEntity> obj) {
		return ro.saveAll(obj);
	}
}
