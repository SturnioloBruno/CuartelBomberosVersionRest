package com.brunix.bomberos.CuartelBomberos.siniestro;

import com.brunix.bomberos.CuartelBomberos.bombero.BomberoDto;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class SiniestroController {

    @Autowired
    private SiniestroService siniestroService;

    @GetMapping("siniestros")
    public ResponseEntity<List<SiniestroDto>> showAll() {
        List<SiniestroDto> siniestroDtos = siniestroService.listAll();

        if (siniestroDtos == null || siniestroDtos.isEmpty()) {
            return ResponseEntity.noContent().header("Mensaje", "No se encontraron siniestros").build();
        }

        return ResponseEntity.ok(siniestroDtos);
    }

    @PostMapping("siniestro")
    public ResponseEntity<?> create(@RequestBody SiniestroDto siniestroDto){
        return ResponseEntity.ok(siniestroService.save(siniestroDto));
    }

    @PutMapping("siniestro/{id}")
    public ResponseEntity<?> update(@RequestBody SiniestroDto siniestroDto, @PathVariable Long id) {
        try {
            SiniestroDto updatedSiniestro = siniestroService.update(siniestroDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(updatedSiniestro.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Siniestro no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest()
                    .header("Mensaje", "Error al procesar la solicitud: " + exDt.getMessage())
                    .build();
        }
    }

    @DeleteMapping("siniestro/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            SiniestroDto siniestroDto = siniestroService.findById(id);

            if (siniestroDto != null) {
                siniestroService.delete(siniestroDto);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound()
                        .header("Mensaje", "Siniestro no encontrado con el ID: " + id)
                        .build();
            }
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Siniestro no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }

    @GetMapping("siniestro/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        try {
            SiniestroDto siniestroDto = siniestroService.findById(id);
            return ResponseEntity.ok(siniestroDto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Siniestro no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }
}
