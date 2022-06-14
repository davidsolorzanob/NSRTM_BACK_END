package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.TipoRelacionado;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TipoRelacionadoRepository extends JpaRepository<TipoRelacionado, Integer> {
}
