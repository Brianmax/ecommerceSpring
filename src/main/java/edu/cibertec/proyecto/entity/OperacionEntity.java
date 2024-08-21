package edu.cibertec.proyecto.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operaciones")
public class OperacionEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int operaciones;
	private String proceso;
	private int tipo;
	@ManyToOne
	@JoinColumn(name = "producto_id")
	private ProductoEntity producto;
	private int cantidad;
	private Double preciocpa;
	private Date fechacpa;
	private int estado;


	public OperacionEntity(String proceso, int tipo, ProductoEntity producto, int cantidad,
						   Double precio, Date fechacpa, int estado) {
		this.operaciones = operaciones;
		this.proceso = proceso;
		this.tipo = tipo;
		this.producto = producto;
		this.cantidad = cantidad;
		this.preciocpa = precio;
		this.fechacpa = fechacpa;
		this.estado = estado;
	}
}
