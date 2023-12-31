package com.brunix.bomberos.CuartelBomberos.cuartel;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CuartelService {
    @Autowired
    private CuartelRepository cuartelRepository;
    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public CuartelDto save(CuartelDto cuartelDto) {
        Cuartel cuartel = modelMapper.map(cuartelDto, Cuartel.class);
        return modelMapper.map(cuartelRepository.save(cuartel), CuartelDto.class);
    }

    @Transactional
    public CuartelDto update(Long id, CuartelDto cuartelDto) {
        Cuartel cuartelExistente = cuartelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuartel no encontrado con el ID: " + id));

        // Actualizar manualmente los campos del cuartel existente con los valores del DTO
        modelMapper.map(cuartelDto, cuartelExistente);

        return modelMapper.map(cuartelRepository.save(cuartelExistente), CuartelDto.class);

        // este metodo actualizar podria dejarle la responsabilidad al framework y dejarlo como:
        /*
        Cuartel cuartel = modelMapper.map(cuartelDto, Cuartel.class);
        return modelMapper.map(cuartelRepository.save(cuartel), CuartelDto.class);
        */
        // esto lo que hace es fijarse en el body si le pongo un id, y el verbo es un Put, automaticamente hace un update

    }



    @Transactional(readOnly = true)
    public List<CuartelDto> listAll(){
        Iterable<Cuartel> cuarteles = cuartelRepository.findAll();
        List<Cuartel> cuartelesList = IterableUtils.toList(cuarteles);

        return  cuartelesList.stream()
                .map(cuartel -> modelMapper.map(cuartel, CuartelDto.class))
                .collect(Collectors.toList());

    }


    @Transactional(readOnly = true)
    public CuartelDto findById(Long id) {
        Cuartel cuartel = cuartelRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cuartel no encontrado con el ID: " + id));
        return modelMapper.map(cuartel, CuartelDto.class);
    }


    @Transactional
    public void delete(CuartelDto cuartelDto){
        cuartelRepository.delete(modelMapper.map(cuartelDto, Cuartel.class));
    }

    public boolean existsById(Long id){
        return cuartelRepository.existsById(id);
    }

}
