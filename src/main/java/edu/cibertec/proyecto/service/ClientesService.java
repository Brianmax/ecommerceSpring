package edu.cibertec.proyecto.service;

import edu.cibertec.proyecto.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientesService {
	
	public Page<ClienteEntity> listar(int page, int size);
	public ClienteEntity buscarCliente(int codigo);
	public boolean eliminarCliente(int id);
	public boolean modificarCliente(ClienteEntity obj);
	public ClienteEntity crearCliente(ClienteEntity obj);
	
	
}
