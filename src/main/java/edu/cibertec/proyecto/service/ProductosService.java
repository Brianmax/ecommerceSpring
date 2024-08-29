package edu.cibertec.proyecto.service;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.proyecto.aggregate.request.ProductoRequest;
import edu.cibertec.proyecto.entity.ProductoEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ProductosService {

	List<ProductoEntity> listar(int page, int size);
	ProductoEntity buscarProducto(int idProducto);
	boolean eliminarProducto(int idProduct);
	ProductoEntity modificarProducto(ProductoEntity obj, int id);
	ProductoEntity crearProducto(ProductoRequest productoRequest);
	JasperPrint exportReport(String report)throws FileNotFoundException, JRException;
}
