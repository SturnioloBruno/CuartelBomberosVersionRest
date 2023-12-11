package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping("cuartel")
    public ResponseEntity<?> create(@RequestBody CuartelDto cuartelDto){
        return ResponseEntity.ok(cuartelService.save(cuartelDto));
    }

    @PutMapping("cuartel/{id}")
    public ResponseEntity<?> update(@RequestBody CuartelDto cuartelDto, @PathVariable Long id) {
        try {
            CuartelDto updatedCuartel = cuartelService.update(id, cuartelDto);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .buildAndExpand(updatedCuartel.getId())
                    .toUri();

            return ResponseEntity.created(location).build();
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Cuartel no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest()
                    .header("Mensaje", "Error al procesar la solicitud: " + exDt.getMessage())
                    .build();
        }
    }



    @DeleteMapping("cuarteles/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            CuartelDto cuartelDto = cuartelService.findById(id);

            if (cuartelDto != null) {
                cuartelService.delete(cuartelDto);
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound()
                        .header("Mensaje", "Cuartel no encontrado con el ID: " + id)
                        .build();
            }
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Cuartel no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }




    @GetMapping("cuartel/{id}")
    public ResponseEntity<?> showById(@PathVariable Long id) {
        try {
            CuartelDto cuartelDto = cuartelService.findById(id);
            return ResponseEntity.ok(cuartelDto);
        } catch (EntityNotFoundException ex) {
            return ResponseEntity.notFound()
                    .header("Mensaje", "Cuartel no encontrado con el ID: " + id)
                    .build();
        } catch (DataAccessException exDt) {
            return ResponseEntity.badRequest().header("Mensaje", exDt.getMessage()).build();
        }
    }

}
