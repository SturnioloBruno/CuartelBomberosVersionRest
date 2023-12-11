package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CuartelDto {
    private Long id;
    private String nombre;
    private String direccion;
    private int coordX;
    private int coordY;
    private String telefono;
    private String correo;
}
