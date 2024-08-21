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
@Table(name="ventas")
public class VentaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private int idVentas;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClienteEntity cliente;
	private Double precio;
	private Date fecha;
	private boolean estado;
}
