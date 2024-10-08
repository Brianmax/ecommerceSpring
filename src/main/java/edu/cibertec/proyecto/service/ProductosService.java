package edu.cibertec.proyecto.service;

import java.io.FileNotFoundException;
import java.util.List;

import edu.cibertec.proyecto.aggregate.request.ProductoRequest;
import edu.cibertec.proyecto.aggregate.request.ProductoUpdateRequest;
import edu.cibertec.proyecto.entity.ProductoEntity;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface ProductosService {

	List<ProductoEntity> listar();
	ProductoEntity buscarProducto(int idProducto);
	boolean eliminarProducto(int idProduct);
	ProductoEntity modificarProducto(ProductoUpdateRequest obj, int id);
	ProductoEntity crearProducto(ProductoRequest productoRequest);
	JasperPrint exportReport(String report)throws FileNotFoundException, JRException;
}
