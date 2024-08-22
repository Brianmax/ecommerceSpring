package edu.cibertec.proyecto.service;

import java.util.List;

import edu.cibertec.proyecto.entity.ProveedorEntity;

public interface ProveedorService {

	public List<ProveedorEntity> listar(int page, int size);
	public ProveedorEntity buscarProveedor(int codigo);
	public boolean eliminarProveedor(int idProveedor);
	public ProveedorEntity modificarProveedor(ProveedorEntity obj, int idProveedor);
	public ProveedorEntity crearProveedor(ProveedorEntity obj);
	
}
