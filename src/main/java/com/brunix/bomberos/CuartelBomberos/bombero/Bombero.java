package com.brunix.bomberos.CuartelBomberos.bombero;

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
@Table(name = "bomberos")
public class Bombero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bombero")
    private Long id;
    private String dni;
    @Column(name = "nombre_ape")
    private String nombreYApellido;
    @Column(name = "fecha_nac")
    private Date fechaNac;
    @ManyToOne()
    @JoinColumn(name = "id_brigada", nullable = false)
    private Brigada brigada;

}
