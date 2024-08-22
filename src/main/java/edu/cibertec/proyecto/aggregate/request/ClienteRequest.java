package edu.cibertec.proyecto.aggregate.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClienteRequest {
    private String dni;
    private String razonSocial;
    private String direccion;
    private String celular;
}
