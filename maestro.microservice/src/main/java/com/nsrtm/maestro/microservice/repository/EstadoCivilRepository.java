package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.EstadoCivil;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoCivilRepository  extends JpaRepository<EstadoCivil, Integer> {
}
