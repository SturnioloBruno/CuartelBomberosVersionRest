package com.brunix.bomberos.CuartelBomberos.siniestro;

import com.brunix.bomberos.CuartelBomberos.brigada.Brigada;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_siniestro")
    private Long id;
    private String tipo;
    @Column(name = "fecha_siniestro")
    private Date fechaSiniestro;
    @Column(name = "coord_X")
    private Integer coordX;
    @Column(name = "coord_Y")
    private Integer coordY;
    private String detalles;
    @Column(name = "fecha_resol")
    private Date fechaResolucion;
    private Integer puntuacion;
    @ManyToOne()
    @JoinColumn(name = "id_brigada", nullable = true)
    private Brigada brigadaResponsable;
}
