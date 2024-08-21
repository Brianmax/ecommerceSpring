package edu.cibertec.proyecto.service.impl;


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
public class ClientesServiceImpl implements ClientesService {
	@Autowired
	ClientesRepository rc;
	
	@Override
	public Page<ClienteEntity> listar(Pageable pageable) {
		return rc.findByEstado(1, pageable);
	}

	@Override
	public ClienteEntity buscarCliente(int codigo) {
		Optional<ClienteEntity> cliente = rc.findById(codigo);
        return cliente.orElse(null);
    }

	@Override
	public boolean eliminarCliente(int id) {
		Optional<ClienteEntity> cliente = rc.findById(id);
		if (cliente.isPresent()) {
			ClienteEntity cli = cliente.get();
			cli.setEstado(0);
			rc.save(cli);
			return true;
		}
		return false;
	}

	@Override
	public boolean modificarCliente(ClienteEntity obj) {
		Optional<ClienteEntity> cliente = rc.findById(obj.getIdcliente());
		if (cliente.isPresent()) {
			ClienteEntity cli = cliente.get();
			cli.setIdcliente(obj.getIdcliente());
			cli.setCelular(obj.getCelular());
			cli.setDireccion(obj.getDireccion());
			cli.setRazonsocial(obj.getRazonsocial());
			cli.setRucdni(obj.getRucdni());
			cli.setEstado(1);
			rc.save(cli);
			return true;
		}
		return false;
	}

	@Override
	public ClienteEntity crearCliente(ClienteEntity obj) {
		String rucdni = obj.getRucdni();
		if (rc.existsByRucdni(rucdni)) {
			return null;
		}
		obj.setEstado(1);
		return rc.save(obj);
	}

}
