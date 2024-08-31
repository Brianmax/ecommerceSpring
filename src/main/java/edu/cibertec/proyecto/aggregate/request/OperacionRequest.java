package edu.cibertec.proyecto.aggregate.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OperacionRequest {
    private int productoId;
    private int cantidad;
    private double precio;
}
