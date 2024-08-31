package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="clientes")
public class ClienteEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cliente_id")
	private int idcliente;
	@NotEmpty
	private String rucdni;
	@NotEmpty
	private String razonsocial;
	private String direccion;
	private String celular;
	private boolean estado;

}
