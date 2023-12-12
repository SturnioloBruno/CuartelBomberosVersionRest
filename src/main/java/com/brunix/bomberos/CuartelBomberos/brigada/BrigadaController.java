package com.brunix.bomberos.CuartelBomberos.brigada;

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
public class BrigadaController {
    @Autowired
    private BrigadaService brigadaService;

    @GetMapping("brigadas")
    public ResponseEntity<List<BrigadaDto>> showAll() {
        List<BrigadaDto> brigadaDtos = brigadaService.listAll();

        if (brigadaDtos == null || brigadaDtos.isEmpty()) {
            return ResponseEntity.noContent().header("Mensaje", "No se encontraron brigadas").build();
        }

        return ResponseEntity.ok(brigadaDtos);
    }

    @PostMapping("brigada")
    public ResponseEntity<?> create(@RequestBody BrigadaDto brigadaDto) {
        return ResponseEntity.ok(brigadaService.save(brigadaDto));
    }

    @PutMapping("brigada/{id}")
    public ResponseEntity<?> update(@RequestBody BrigadaDto brigadaDto, @PathVariable Long id) {
        try{
            BrigadaDto updatedBrigada = brigadaService.update(id, brigadaDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(updatedBrigada.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Brigada no encontrada con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest()
                    .header("Mensaje", "Error al procesar la solicitud: " + exDt.getMessage())
                    .build();
        }
    }

    @DeleteMapping("brigadas/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            BrigadaDto brigadaDto = brigadaService.findById(id);

            if (brigadaDto != null) {
                brigadaService.delete(brigadaDto);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound()
                        .header("Mensaje", "Brigada no encontrada con el Id: " + id)
                        .build();
            }
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Brigada no encontrada con el Id: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }

    @GetMapping("brigada/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        try {
            BrigadaDto brigadaDto = brigadaService.findById(id);
            return ResponseEntity.ok(brigadaDto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Brigada no encontrado con el Id: " + id)
                    .build();
        } catch(DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }
}
