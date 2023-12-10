package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CuartelDto {
    private Long id;
    private String nombre;
    private String direccion;
    private int coordX;
    private int coordY;
    private String telefono;
    private String correo;
}
