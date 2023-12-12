package com.brunix.bomberos.CuartelBomberos.bombero;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BomberoRepository extends CrudRepository<Bombero, Long> {
}
