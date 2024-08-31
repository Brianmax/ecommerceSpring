package edu.cibertec.proyecto.service.impl;


import edu.cibertec.proyecto.aggregate.request.ClienteRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.ClienteEntity;
import edu.cibertec.proyecto.repository.ClientesRepository;
import edu.cibertec.proyecto.service.ClientesService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {
	ClientesRepository clientesRepository;
	
	@Override
	public List<ClienteEntity> listar() {
		return clientesRepository.findAll();
	}

	@Override
	public ClienteEntity buscarCliente(int codigo) {
		Optional<ClienteEntity> cliente = clientesRepository.findById(codigo);
        return cliente.orElse(null);
    }

	@Override
	public boolean eliminarCliente(int id) {
		Optional<ClienteEntity> cliente = clientesRepository.findById(id);
		if (cliente.isPresent()) {
			ClienteEntity cli = cliente.get();
			cli.setEstado(true);
			clientesRepository.save(cli);
			return true;
		}
		return false;
	}

	@Override
	public boolean modificarCliente(ClienteRequest obj, int idCliente) {
		Optional<ClienteEntity> cliente = clientesRepository.findById(idCliente);
		if (cliente.isPresent()) {
			ClienteEntity cli = cliente.get();
			cli.setCelular(obj.getCelular());
			cli.setDireccion(obj.getDireccion());
			cli.setRazonsocial(obj.getRazonSocial());
			//cli.setRucdni(obj.getDni());
			cli.setEstado(true);
			clientesRepository.save(cli);
			return true;
		}
		return false;
	}

	@Override
	public ClienteEntity crearCliente(ClienteRequest obj) {
		String rucdni = obj.getDni();
		if (clientesRepository.existsByRucdni(rucdni)) {
			return null;
		}
		ClienteEntity cliente = new ClienteEntity();
		cliente.setRucdni(obj.getDni());
		cliente.setRazonsocial(obj.getRazonSocial());
		cliente.setDireccion(obj.getDireccion());
		cliente.setCelular(obj.getCelular());
		cliente.setEstado(true);
		return clientesRepository.save(cliente);
	}

}
