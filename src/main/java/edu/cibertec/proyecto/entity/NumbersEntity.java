package edu.cibertec.proyecto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="numbers")
public class NumbersEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "number_id")
	private int idnumber;
	private String prefij;
	private int numeracion;

	public String codigoconPrefijo() {
		String cod = getPrefij() + getNumeracion();
		return cod;
	}

}
