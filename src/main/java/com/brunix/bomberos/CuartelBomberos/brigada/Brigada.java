package com.brunix.bomberos.CuartelBomberos.brigada;

import com.brunix.bomberos.CuartelBomberos.bombero.Bombero;
import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import com.brunix.bomberos.CuartelBomberos.siniestro.Siniestro;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
    @ManyToOne()
    @JoinColumn(name = "id_cuartel", nullable = false)
    private Cuartel cuartel;
    @OneToMany(mappedBy = "brigada")
    @JsonIgnore
    private Set<Bombero> bomberos;
    @OneToMany(mappedBy = "brigadaResponsable")
    @JsonIgnore
    private Set<Siniestro> siniestrosAsignados;
}
