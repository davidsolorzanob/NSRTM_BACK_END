package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.MedioDeterminacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedioDeterminacionRepository  extends JpaRepository<MedioDeterminacion, Integer> {
}
