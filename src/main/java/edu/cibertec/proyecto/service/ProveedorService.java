package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.ProveedorEntity;

public interface ProveedorService {

	List<ProveedorEntity> listar();
	ProveedorEntity buscarProveedor(int codigo);
	boolean eliminarProveedor(int idProveedor);
	ProveedorEntity modificarProveedor(ProveedorEntity obj, int idProveedor);
	ProveedorEntity crearProveedor(ProveedorEntity obj);

}
