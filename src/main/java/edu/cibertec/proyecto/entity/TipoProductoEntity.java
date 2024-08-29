package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tipo_productos")
public class TipoProductoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tipo_id")
	private int idtipo;
	private String nombre;
	private String descripcion;
}
