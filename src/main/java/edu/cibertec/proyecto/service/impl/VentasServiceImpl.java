package edu.cibertec.proyecto.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.VentaEntity;
import edu.cibertec.proyecto.repository.VentasRepository;
import edu.cibertec.proyecto.service.VentasService;
@Service
@AllArgsConstructor
public class VentasServiceImpl implements VentasService {
	VentasRepository rv;
	
	@Override
	public VentaEntity crearVenta(VentaEntity obj) {
		return rv.save(obj);
	}
}
