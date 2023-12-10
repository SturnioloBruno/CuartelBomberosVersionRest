package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "cuarteles")
public class Cuartel {
    @Id
    @Column(name = "id_cuartel")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_cuartel")
    private String nombre;
    private String direccion;
    private int coordX;
    private int coordY;
    private String telefono;
    private String correo;
}
