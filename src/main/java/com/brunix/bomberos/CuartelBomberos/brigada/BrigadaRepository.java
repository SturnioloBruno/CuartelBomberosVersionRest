package com.brunix.bomberos.CuartelBomberos.brigada;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrigadaRepository extends CrudRepository<Brigada, Long> {
}
