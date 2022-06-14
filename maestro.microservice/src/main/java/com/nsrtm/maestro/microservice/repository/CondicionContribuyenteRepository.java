package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.CondicionContribuyente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicionContribuyenteRepository  extends JpaRepository<CondicionContribuyente, Integer> {
}
