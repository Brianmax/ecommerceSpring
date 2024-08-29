package edu.cibertec.proyecto.aggregate.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequest {
    private String nombre;
    private String descripcion;
    private double precio;
    private int stockMin;
    private int stockMax;
    private int proveedorId;
    private int tipoId;
}
