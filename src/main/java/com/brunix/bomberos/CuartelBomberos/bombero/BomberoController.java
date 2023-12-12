package com.brunix.bomberos.CuartelBomberos.bombero;

import com.brunix.bomberos.CuartelBomberos.cuartel.CuartelDto;
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
public class BomberoController {
    @Autowired
    private BomberoService bomberoService;

    @GetMapping("bomberos")
    public ResponseEntity<List<BomberoDto>> showAll() {
        List<BomberoDto> bomberoDtos = bomberoService.listAll();

        if (bomberoDtos == null || bomberoDtos.isEmpty()) {
            return ResponseEntity.noContent().header("Mensaje", "No se encontraron bomberos").build();
        }

        return ResponseEntity.ok(bomberoDtos);
    }

    @PostMapping("bombero")
    public ResponseEntity<?> create(@RequestBody BomberoDto bomberoDto){
        return ResponseEntity.ok(bomberoService.save(bomberoDto));
    }

    @PutMapping("bombero/{id}")
    public ResponseEntity<?> update(@RequestBody BomberoDto bomberoDto, @PathVariable Long id) {
        try {
            BomberoDto updatedBombero = bomberoService.update(bomberoDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(updatedBombero.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Bombero no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest()
                    .header("Mensaje", "Error al procesar la solicitud: " + exDt.getMessage())
                    .build();
        }
    }

    @DeleteMapping("bombero/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            BomberoDto bomberoDto = bomberoService.findById(id);

            if (bomberoDto != null) {
                bomberoService.delete(bomberoDto);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound()
                        .header("Mensaje", "Bombero no encontrado con el ID: " + id)
                        .build();
            }
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Bombero no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }

    @GetMapping("bombero/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        try {
            BomberoDto bomberoDto = bomberoService.findById(id);
            return ResponseEntity.ok(bomberoDto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Bombero no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }
}
