package com.brunix.bomberos.CuartelBomberos.cuartel;

import com.brunix.bomberos.CuartelBomberos.brigada.Brigada;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    @OneToMany(mappedBy = "cuartel")
    @JsonIgnore
    private Set<Brigada> brigadas;

}
