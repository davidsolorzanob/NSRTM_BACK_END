package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.MotivoDj;

public interface MotivoDjRepository  extends JpaRepository<MotivoDj, Integer> {
}
