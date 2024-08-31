package edu.cibertec.proyecto.service.impl;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.ProveedorEntity;
import edu.cibertec.proyecto.repository.ProveedorRepository;
import edu.cibertec.proyecto.service.ProveedorService;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class ProveedorServiceImpl implements ProveedorService {
	@Autowired
	private ProveedorRepository proveedorRepository;
	
	@Override
	public List<ProveedorEntity> listar() {
		return proveedorRepository.findAll();
	}

	@Override
	public ProveedorEntity buscarProveedor(int idProveedor) {
		return proveedorRepository.findById(idProveedor).orElse(null);
	}
	@Override
	public boolean eliminarProveedor(int idProveedor) {
		ProveedorEntity prov = proveedorRepository.findById(idProveedor).orElse(null);
		if (prov == null) {
			return false;
		}
		prov.setEstado(false);
		proveedorRepository.save(prov);
		return true;
	}

	@Override
	public ProveedorEntity modificarProveedor(ProveedorEntity obj, int idProveedor) {
		ProveedorEntity prov = proveedorRepository.findById(obj.getIdproveedor()).orElse(null);
		if (prov == null) {
			return null;
		}
		prov.setIdproveedor(obj.getIdproveedor());
		prov.setCelular(obj.getCelular());
		prov.setCorreo(obj.getCorreo());
		prov.setRazonsocial(obj.getRazonsocial());
		prov.setRucdni(obj.getRucdni());
		prov.setEstado(true);
		return proveedorRepository.save(prov);
	}

	@Override
	public ProveedorEntity crearProveedor(ProveedorEntity obj) {
		String dni = obj.getRucdni();
		if (proveedorRepository.existsByRucdni(dni))
		{
			return null;
		}
		return proveedorRepository.save(obj);
	}

}
