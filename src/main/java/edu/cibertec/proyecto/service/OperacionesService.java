package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.OperacionEntity;

public interface OperacionesService {

	public OperacionEntity crearOperaciones(OperacionEntity obj);
	public List<OperacionEntity> crearMultiplesOperaciones(List<OperacionEntity> obj);

}
