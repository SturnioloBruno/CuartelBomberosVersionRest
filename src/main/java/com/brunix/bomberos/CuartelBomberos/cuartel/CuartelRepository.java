package com.brunix.bomberos.CuartelBomberos.cuartel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuartelRepository extends CrudRepository<Cuartel,Long> {
}
