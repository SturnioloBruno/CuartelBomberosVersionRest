package com.brunix.bomberos.CuartelBomberos.siniestro;

import com.brunix.bomberos.CuartelBomberos.brigada.Brigada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SiniestroDto {

    private Long id;
    private String tipo;
    private Date fechaSiniestro;
    private Integer coordX;
    private Integer coordY;
    private String detalles;
    private Date fechaResolucion;
    private Integer puntuacion;
    private Brigada brigadaResponsable;
}
