package edu.cibertec.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.TipoProductoEntity;
import edu.cibertec.proyecto.repository.TipoProductosRepository;
import edu.cibertec.proyecto.service.TipoproductosService;

@Service
public class TipoProductosServiceImpl implements TipoproductosService {
	@Autowired
	TipoProductosRepository rt;
	
	@Override
	public List<TipoProductoEntity> listar() {
		
		return rt.findAll();
	}

}
