package edu.cibertec.proyecto.entity;

import java.util.Date;

import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tb_ventas")
public class VentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ventas;
	@ManyToOne
	@JoinColumn(name = "cliente")
	private ClienteEntity cliente;
	private Double precio;
	private Date fecha;
	private int estado;


}
