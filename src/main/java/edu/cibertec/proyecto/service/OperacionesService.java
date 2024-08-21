package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.OperacionEntity;

public interface OperacionesService {

	public void crearOperaciones(OperacionEntity obj);
	public void crearMultiplesOperaciones(List<OperacionEntity> obj);

}
