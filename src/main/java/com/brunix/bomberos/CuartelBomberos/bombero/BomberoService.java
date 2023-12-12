package com.brunix.bomberos.CuartelBomberos.bombero;

import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import com.brunix.bomberos.CuartelBomberos.cuartel.CuartelDto;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BomberoService {
    @Autowired
    private BomberoRepository bomberoRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public BomberoDto save (BomberoDto bomberoDto) {
        Bombero bombero = modelMapper.map(bomberoDto, Bombero.class);
        return modelMapper.map(bomberoRepository.save(bombero), BomberoDto.class);
    }

    @Transactional
    BomberoDto update(BomberoDto bomberoDto) {
        // en el body si viene un id detecta que es un updtate
        Bombero bombero = modelMapper.map(bomberoDto, Bombero.class);
        return modelMapper.map(bomberoRepository.save(bombero), BomberoDto.class);
    }

    @Transactional(readOnly = true)
    public List<BomberoDto> listAll(){
        Iterable<Bombero> bomberos = bomberoRepository.findAll();
        List<Bombero> bomberoList = IterableUtils.toList(bomberos);

        return  bomberoList.stream()
                .map(bombero -> modelMapper.map(bombero, BomberoDto.class))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public BomberoDto findById(Long id) {
        Bombero bombero = bomberoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bombero no encontrado con el ID: " + id));
        return modelMapper.map(bombero, BomberoDto.class);
    }

    @Transactional
    public void delete(BomberoDto bomberoDto){
        bomberoRepository.delete(modelMapper.map(bomberoDto, Bombero.class));
    }

    public boolean existsById(Long id){
        return bomberoRepository.existsById(id);
    }
}
