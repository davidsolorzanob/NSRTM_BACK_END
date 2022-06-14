package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.TipoDomicilio;

public interface TipoDomicilioRepository  extends JpaRepository<TipoDomicilio, Integer> {
}
