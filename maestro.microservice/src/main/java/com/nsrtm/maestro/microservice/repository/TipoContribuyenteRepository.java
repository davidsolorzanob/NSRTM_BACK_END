package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.TipoContribuyente;

public interface TipoContribuyenteRepository  extends JpaRepository<TipoContribuyente, Integer> {
}
