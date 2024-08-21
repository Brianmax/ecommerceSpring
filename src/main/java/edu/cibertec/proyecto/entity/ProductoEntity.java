package edu.cibertec.proyecto.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_productos")

public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private int idprod;
	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TipoProductoEntity tipo;
	
	private String descripcion;
	private Double precio;
	@Column(name = "stock_min")
	private int stockMin;
	@Column(name = "stock_max")
	private int stockMax;
	@ManyToOne
	@JoinColumn(name = "proveedor_id")
	private ProveedorEntity proveedor;
	private boolean estado;
	
	@OneToMany(mappedBy = "producto")
	List<OperacionEntity> productos;

	public int getStock() {
		return productos.stream().mapToInt(o -> o.getCantidad()).sum();
	}
	
	public boolean getReponer() {
		int stk = getStock();
		boolean men = false;
		if (stk < getStockMin()) {
			men = true;
		}else {
			men = false;
		}
		return men;
	}
}
