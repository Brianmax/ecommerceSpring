package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name="proveedores")
public class ProveedorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proveedor_id")
	private int idproveedor;
	private String rucdni;
	private String razonsocial;
	private String celular;
	private String correo;
	private boolean estado;
}
