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

}
