package edu.cibertec.proyecto.service.impl;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.ClienteEntity;
import edu.cibertec.proyecto.repository.ClientesRepository;
import edu.cibertec.proyecto.service.ClientesService;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClientesServiceImpl implements ClientesService {
	ClientesRepository clientesRepository;
	
	@Override
	public Page<ClienteEntity> listar(int page, int size) {
		return clientesRepository.findAll(Pageable.ofSize(size).withPage(page));
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
	public boolean modificarCliente(ClienteEntity obj) {
		Optional<ClienteEntity> cliente = clientesRepository.findById(obj.getIdcliente());
		if (cliente.isPresent()) {
			ClienteEntity cli = cliente.get();
			cli.setIdcliente(obj.getIdcliente());
			cli.setCelular(obj.getCelular());
			cli.setDireccion(obj.getDireccion());
			cli.setRazonsocial(obj.getRazonsocial());
			cli.setRucdni(obj.getRucdni());
			cli.setEstado(true);
			clientesRepository.save(cli);
			return true;
		}
		return false;
	}

	@Override
	public ClienteEntity crearCliente(ClienteEntity obj) {
		String rucdni = obj.getRucdni();
		if (clientesRepository.existsByRucdni(rucdni)) {
			return null;
		}
		obj.setEstado(true);
		return clientesRepository.save(obj);
	}

}
