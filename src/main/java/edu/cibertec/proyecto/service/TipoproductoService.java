package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.TipoProductoEntity;

public interface TipoproductoService {
	TipoProductoEntity crear(TipoProductoEntity obj);
	List<TipoProductoEntity> listar();
}
