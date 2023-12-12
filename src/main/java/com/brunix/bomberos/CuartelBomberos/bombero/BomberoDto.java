package com.brunix.bomberos.CuartelBomberos.bombero;

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
public class BomberoDto {

    private Long id;
    private String dni;

    private String nombreYApellido;

    private Date fechaNac;

    private Brigada brigada;
}
