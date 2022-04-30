package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.TipoMaestro;

public interface TipoMaestroRepository  extends JpaRepository<TipoMaestro, Integer> {
}
