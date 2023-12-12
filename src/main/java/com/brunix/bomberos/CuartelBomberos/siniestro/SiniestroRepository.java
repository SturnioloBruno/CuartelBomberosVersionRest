package com.brunix.bomberos.CuartelBomberos.siniestro;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiniestroRepository extends CrudRepository<Siniestro, Long> {
}
