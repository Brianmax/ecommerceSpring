package edu.cibertec.proyecto.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cibertec.proyecto.entity.ProveedorEntity;
import edu.cibertec.proyecto.repository.ProveedoresRepository;
import edu.cibertec.proyecto.service.ProveedoresService;

@Service
public class ProveedoresServiceImpl implements ProveedoresService {
	@Autowired
	ProveedoresRepository rp;
	
	@Override
	public List<ProveedorEntity> listar() {
		
		return rp.findByEstado(1);
	}

	@Override
	public ProveedorEntity buscarProveedor(int codigo) {
		
		return rp.findById(codigo).orElse(null);
	}

	@Override
	public void eliminarProveedor(ProveedorEntity obj) {
		ProveedorEntity prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setEstado(0);
		rp.save(prov);
		
	}

	@Override
	public void modificarProveedor(ProveedorEntity obj) {
		ProveedorEntity prov = rp.findById(obj.getIdproveedor()).orElse(null);
		prov.setIdproveedor(obj.getIdproveedor());
		prov.setCelular(obj.getCelular());
		prov.setCorreo(obj.getCorreo());
		prov.setRazonsocial(obj.getRazonsocial());
		prov.setRucdni(obj.getRucdni());
		prov.setEstado(1);
		rp.save(prov);
	}

	@Override
	public void crearProveedor(ProveedorEntity obj) {
		rp.save(obj);
		
	}

}
