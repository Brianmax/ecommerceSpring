package edu.cibertec.proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.VentaEntity;
import edu.cibertec.proyecto.repository.VentasRepository;
import edu.cibertec.proyecto.service.VentasService;
@Service
public class VentasServiceImpl implements VentasService {
	@Autowired
	VentasRepository rv;
	
	@Override
	public VentaEntity crearVemtas(VentaEntity obj) {
		return rv.save(obj);
	}

}
