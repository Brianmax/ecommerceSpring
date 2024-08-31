package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.aggregate.request.OperacionRequest;
import edu.cibertec.proyecto.entity.OperacionEntity;

public interface OperacionesService {

	public OperacionEntity crearOperaciones(OperacionRequest obj);
	public List<OperacionEntity> crearMultiplesOperaciones(List<OperacionEntity> obj);

}
