package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.Interior;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InteriorRepository  extends JpaRepository<Interior, Integer> {
}
