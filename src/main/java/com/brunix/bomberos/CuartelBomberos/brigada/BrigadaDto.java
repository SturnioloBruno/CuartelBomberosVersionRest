package com.brunix.bomberos.CuartelBomberos.brigada;

import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import com.brunix.bomberos.CuartelBomberos.cuartel.CuartelDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BrigadaDto {

    private Long id;
    private String nombre;
    private String especialidad;
    private Boolean libre;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CuartelDto cuartelDto;
}
