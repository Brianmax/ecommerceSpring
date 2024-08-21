package edu.cibertec.proyecto.service;

import edu.cibertec.proyecto.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClientesService {
	
	public Page<ClienteEntity> listar(Pageable pageable);
	public ClienteEntity buscarCliente(int codigo);
	public void eliminarCliente(ClienteEntity obj);
	public void modificarCliente(ClienteEntity obj);
	public void crearCliente(ClienteEntity obj);
	
	
}
