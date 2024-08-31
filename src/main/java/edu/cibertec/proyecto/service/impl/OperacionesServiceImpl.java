package edu.cibertec.proyecto.service.impl;

import java.util.Date;
import java.util.List;

import edu.cibertec.proyecto.aggregate.request.OperacionRequest;
import edu.cibertec.proyecto.aggregate.request.ProductoRequest;
import edu.cibertec.proyecto.aggregate.request.ProductoUpdateRequest;
import edu.cibertec.proyecto.entity.ProductoEntity;
import edu.cibertec.proyecto.repository.ProductosRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.cibertec.proyecto.entity.OperacionEntity;
import edu.cibertec.proyecto.repository.OperacionesRepository;
import edu.cibertec.proyecto.service.OperacionesService;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class OperacionesServiceImpl implements OperacionesService {
	private OperacionesRepository ro;
	private ProductosRepository rp;
	@Override
	public OperacionEntity crearOperaciones(OperacionRequest obj) {
		OperacionEntity operacionEntity = new OperacionEntity();
		operacionEntity.setProceso("PROC_VENTA");
		operacionEntity.setTipo(1);
		operacionEntity.setCantidad(obj.getCantidad());
		operacionEntity.setPreciocpa(obj.getPrecio());
		operacionEntity.setFechacpa(new Date());
		operacionEntity.setEstado(1);
		ProductoEntity productoEntity = rp.findById(obj.getProductoId()).orElse(null);
		if (productoEntity != null) {
			operacionEntity.setProducto(productoEntity);
			//productoEntity.setStock(productoEntity.getStock() - obj.getCantidad());
			rp.save(productoEntity);
			return ro.save(operacionEntity);
		}
		return null;
	}

	@Override
	public List<OperacionEntity> crearMultiplesOperaciones(List<OperacionEntity> obj) {
		return ro.saveAll(obj);
	}
}
