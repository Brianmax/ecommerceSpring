package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.ProveedorEntity;

public interface ProveedoresService {

	public List<ProveedorEntity> listar();
	public ProveedorEntity buscarProveedor(int codigo);
	public void eliminarProveedor(ProveedorEntity obj);
	public void modificarProveedor(ProveedorEntity obj);
	public void crearProveedor(ProveedorEntity obj);
	
}
