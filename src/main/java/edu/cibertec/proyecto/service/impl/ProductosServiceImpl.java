package edu.cibertec.proyecto.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import edu.cibertec.proyecto.aggregate.request.ProductoRequest;
import edu.cibertec.proyecto.aggregate.request.ProductoUpdateRequest;
import edu.cibertec.proyecto.entity.ProveedorEntity;
import edu.cibertec.proyecto.entity.TipoProductoEntity;
import edu.cibertec.proyecto.repository.ProveedorRepository;
import edu.cibertec.proyecto.repository.TipoProductoRepository;
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
	private ProveedorRepository proveedorRepository;
	private TipoProductoRepository tipoProductoRepository;
	
	@Override
	public List<ProductoEntity> listar() {
		return productosRepository.findByEstado(true);
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
	public ProductoEntity modificarProducto(ProductoUpdateRequest obj, int id) {
		Optional<ProductoEntity> cap = productosRepository.findById(id);
		ProveedorEntity prov = proveedorRepository.findByRazonsocial(obj.getProveedor()).orElse(null);
		TipoProductoEntity tip = tipoProductoRepository.findByDescripcion(obj.getTipo()).orElse(null);
		if (prov == null || tip == null) {
			return null;
		}
		if (cap.isPresent()) {

			ProductoEntity cap2 = cap.get();
			cap2.setPrecio(obj.getPrecio());
			cap2.setDescripcion(obj.getDescripcion());
			cap2.setStockMax(obj.getStockMax());
			cap2.setStockMin(obj.getStockMin());
			cap2.setProveedor(prov);
			cap2.setTipo(tip);
			productosRepository.save(cap2);
			return cap2;
		}
		return null;
	}

	@Override
	public ProductoEntity crearProducto(ProductoRequest productoRequest) {
		ProductoEntity producto = new ProductoEntity();
		producto.setDescripcion(productoRequest.getDescripcion());
		producto.setPrecio(productoRequest.getPrecio());
		producto.setStockMin(productoRequest.getStockMin());
		producto.setStockMax(productoRequest.getStockMax());
		//Optional<ProductoEntity> cap = productosRepository.findByNombre(productoRequest.getNombre());
		ProveedorEntity prov = proveedorRepository.findByRazonsocial(productoRequest.getProveedor()).orElse(null);
		TipoProductoEntity tip = tipoProductoRepository.findByDescripcion(productoRequest.getTipo()).orElse(null);
		if (prov == null || tip == null) {
			return null;
		}
		else {
			producto.setEstado(true);
			producto.setProveedor(prov);
			producto.setTipo(tip);
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
