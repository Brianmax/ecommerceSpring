package edu.cibertec.proyecto.service;

import edu.cibertec.proyecto.aggregate.request.ClienteRequest;
import edu.cibertec.proyecto.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientesService {
	
	public List<ClienteEntity> listar();
	public ClienteEntity buscarCliente(int codigo);
	public boolean eliminarCliente(int id);
	public boolean modificarCliente(ClienteRequest obj, int idCliente);
	public ClienteEntity crearCliente(ClienteRequest obj);
	
	
}
