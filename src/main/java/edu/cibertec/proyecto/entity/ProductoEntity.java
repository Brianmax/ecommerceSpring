package edu.cibertec.proyecto.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "productos")
public class ProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producto_id")
	private int idprod;
	@ManyToOne
	@JoinColumn(name = "tipo")
	private TipoProductoEntity tipo;
	private String descripcion;
	private Double precio;
	@Column(name = "stock_min")
	private int stockMin;
	@Column(name = "stock_max")
	private int stockMax;
	@ManyToOne
	@JoinColumn(name = "proveedor")
	private ProveedorEntity proveedor;
	private boolean estado;
	
	/*@OneToMany(mappedBy = "producto")
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
	}*/
}
