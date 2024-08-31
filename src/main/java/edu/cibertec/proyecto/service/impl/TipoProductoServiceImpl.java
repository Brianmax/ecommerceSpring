package edu.cibertec.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.TipoProductoEntity;
import edu.cibertec.proyecto.repository.TipoProductoRepository;
import edu.cibertec.proyecto.service.TipoproductoService;

@Service
public class TipoProductoServiceImpl implements TipoproductoService {
	@Autowired
	TipoProductoRepository rt;
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

	@Override
	public TipoProductoEntity crear(TipoProductoEntity obj) {
		return rt.save(obj);
	}

	@Override
	public List<TipoProductoEntity> listar() {
		return rt.findAll();
	}
}
