package edu.cibertec.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.OperacionEntity;
import edu.cibertec.proyecto.repository.OperacionesRepository;
import edu.cibertec.proyecto.service.OperacionesService;

@Service
public class OperacionesServiceImpl implements OperacionesService {
	@Autowired
	OperacionesRepository ro;
	
	@Override
	public void crearOperaciones(OperacionEntity obj) {
		
		ro.save(obj);
		
	}

	@Override
	public void crearMultiplesOperaciones(List<OperacionEntity> obj) {
		
		ro.saveAll(obj);
		
	}

}
