package com.brunix.bomberos.CuartelBomberos.brigada;

import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import jakarta.persistence.*;

@Entity
@Table(name = "brigadas")
public class Brigada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_brigada")
    private Long id;
    private String nombre;
    private String especialidad;
    private Boolean libre;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuartel")
    private Cuartel cuartel;
}
