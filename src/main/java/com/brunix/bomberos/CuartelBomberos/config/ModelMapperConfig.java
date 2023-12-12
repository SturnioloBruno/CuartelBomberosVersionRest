package com.brunix.bomberos.CuartelBomberos.config;

import com.brunix.bomberos.CuartelBomberos.brigada.Brigada;
import com.brunix.bomberos.CuartelBomberos.brigada.BrigadaDto;
import com.brunix.bomberos.CuartelBomberos.cuartel.Cuartel;
import com.brunix.bomberos.CuartelBomberos.cuartel.CuartelDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Configuración para ignorar el campo 'id' durante el mapeo de CuartelDto a Cuartel
        /*modelMapper.typeMap(CuartelDto.class, Cuartel.class)
                .addMappings(mapper -> mapper.skip(Cuartel::setId));

        modelMapper.typeMap(BrigadaDto.class, Brigada.class)
                .addMappings(mapper -> mapper.skip(Brigada::setId));*/

        return modelMapper;
    }
}

