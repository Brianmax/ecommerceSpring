package edu.cibertec.proyecto.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import edu.cibertec.proyecto.entity.ProductoEntity;
import edu.cibertec.proyecto.repository.ProductosRepository;
import edu.cibertec.proyecto.service.ProductosService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
@AllArgsConstructor
public class ProductosServiceImpl implements ProductosService {
	private ProductosRepository productosRepository;
	
	@Override
	public List<ProductoEntity> listar(int page, int size) {
		Pageable pageable = Pageable.ofSize(size).withPage(page);
		return productosRepository.findByEstado(true, pageable);
	}

	@Override
	public ProductoEntity buscarProducto(int idProducto) {
		return productosRepository.findById(idProducto).orElse(null);
	}

	@Override
	public boolean eliminarProducto(int idProduct) {
		Optional<ProductoEntity> cap = productosRepository.findById(idProduct);
		if (cap.isPresent()) {
			ProductoEntity cap2 = cap.get();
			cap2.setEstado(false);
			productosRepository.save(cap2);
			return true;
		}
		return false;
	}

	@Override
	public ProductoEntity modificarProducto(ProductoEntity obj, int id) {
		Optional<ProductoEntity> cap = productosRepository.findById(id);
		if (cap.isPresent()) {
			ProductoEntity cap2 = cap.get();
			cap2.setPrecio(obj.getPrecio());
			cap2.setEstado(obj.isEstado());
			cap2.setDescripcion(obj.getDescripcion());
			productosRepository.save(cap2);
			return cap2;
		}
		return null;
	}

	@Override
	public ProductoEntity crearProducto(ProductoEntity producto) {
		Optional<ProductoEntity> cap = productosRepository.findById(producto.getIdprod());
		if (cap.isPresent()) {
			return null;
		}
		else {
			return productosRepository.save(producto);
		}
	}

	@Override
	public JasperPrint exportReport(String repor) throws FileNotFoundException, JRException {
		
		List<ProductoEntity>listadoP = productosRepository.findByEstado(true);
		File archivo = ResourceUtils.getFile(repor);
		JasperReport report = JasperCompileManager.compileReport(archivo.getAbsolutePath());
		JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(listadoP);
		Map<String,Object> parametros = new HashMap<>();
		JasperPrint print = JasperFillManager.fillReport(report, parametros,ds);
		return print;
		
	}

	
	
}
