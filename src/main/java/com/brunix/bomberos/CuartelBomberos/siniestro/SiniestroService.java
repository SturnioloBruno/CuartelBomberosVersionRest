package com.brunix.bomberos.CuartelBomberos.siniestro;

import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SiniestroService {
    @Autowired
    private SiniestroRepository siniestroRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public SiniestroDto save (SiniestroDto siniestroDto) {
        Siniestro bombero = modelMapper.map(siniestroDto, Siniestro.class);
        return modelMapper.map(siniestroRepository.save(bombero), SiniestroDto.class);
    }

    @Transactional
    SiniestroDto update(SiniestroDto siniestroDto) {
        Siniestro siniestro = modelMapper.map(siniestroDto, Siniestro.class);
        return modelMapper.map(siniestroRepository.save(siniestro), SiniestroDto.class);
    }

    @Transactional(readOnly = true)
    public List<SiniestroDto> listAll(){
        Iterable<Siniestro> siniestros = siniestroRepository.findAll();
        List<Siniestro> siniestroList = IterableUtils.toList(siniestros);

        return  siniestroList.stream()
                .map(siniestro -> modelMapper.map(siniestro, SiniestroDto.class))
                .collect(Collectors.toList());

    }

    @Transactional(readOnly = true)
    public SiniestroDto findById(Long id) {
        Siniestro siniestro = siniestroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Siniestro no encontrado con el ID: " + id));
        return modelMapper.map(siniestro, SiniestroDto.class);
    }

    @Transactional
    public void delete(SiniestroDto siniestroDto){
        siniestroRepository.delete(modelMapper.map(siniestroDto, Siniestro.class));
    }

    public boolean existsById(Long id){
        return siniestroRepository.existsById(id);
    }
}
