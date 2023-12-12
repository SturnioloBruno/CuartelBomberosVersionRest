package com.brunix.bomberos.CuartelBomberos.brigada;

import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import com.brunix.bomberos.CuartelBomberos.cuartel.CuartelRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.commons.collections4.IterableUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrigadaService {

    @Autowired
    private BrigadaRepository brigadaRepository;
    @Autowired
    private CuartelRepository cuartelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public BrigadaDto save(BrigadaDto brigadaDto) {
        Brigada brigada = modelMapper.map(brigadaDto, Brigada.class);

        if (brigadaDto.getCuartelDto() != null) {
            Cuartel cuartel = modelMapper.map(brigadaDto.getCuartelDto(), Cuartel.class);
            cuartel = cuartelRepository.save(cuartel); // Guardar el Cuartel por separado

            brigada.setCuartel(cuartel);
        }

        // Guardar la Brigada, asegurándote de que la referencia al Cuartel esté establecida
        return modelMapper.map(brigadaRepository.save(brigada), BrigadaDto.class);
    }




    @Transactional
    public BrigadaDto update(Long id, BrigadaDto brigadaDto){
        Brigada brigadaExistente = brigadaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brigada no encontrada con el ID: " + id));

        modelMapper.map(brigadaDto, brigadaExistente);

        return modelMapper.map(brigadaRepository.save(brigadaExistente), BrigadaDto.class);

    }

    @Transactional(readOnly = true)
    public List<BrigadaDto> listAll() {
        Iterable<Brigada> brigadas = brigadaRepository.findAll();
        List<Brigada> result = IterableUtils.toList(brigadas);

        return result.stream()
                .map(brigada -> modelMapper.map(brigada, BrigadaDto.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BrigadaDto findById(Long id) {
        Brigada brigada = brigadaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Brigada no encontrada con el id " + id));

        return modelMapper.map(brigada, BrigadaDto.class);
    }

    @Transactional
    public void delete(BrigadaDto brigadaDto) {
        brigadaRepository.delete(modelMapper.map(brigadaDto, Brigada.class));
    }

    public boolean existsById(Long id) {return brigadaRepository.existsById(id); }
}
