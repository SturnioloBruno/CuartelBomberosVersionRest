package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class CuartelController {
    @Autowired
    private CuartelService cuartelService;

    @GetMapping("cuarteles")
    public ResponseEntity<List<CuartelDto>> showAll() {
        List<CuartelDto> cuartelDtos = cuartelService.listAll();

        if (cuartelDtos == null || cuartelDtos.isEmpty()) {
            return ResponseEntity.noContent().header("Mensaje", "No se encontraron cuarteles").build();
        }

        return ResponseEntity.ok(cuartelDtos);
    }
}
