package edu.cibertec.proyecto.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.repository.UsuariosRepository;
import edu.cibertec.proyecto.service.UsuariosService;
@Service
public class UsuariosServiceImpl implements UsuariosService {
	@Autowired
	UsuariosRepository ru;
	
	@Override
	public boolean validarLogin(String User, String Password) {
		
		boolean valor = false;
		int result = ru.findByUsuarioAndClave(User, Password).size();
		if (result > 0) {
			valor=true;
		}
		return valor;
	}

}
