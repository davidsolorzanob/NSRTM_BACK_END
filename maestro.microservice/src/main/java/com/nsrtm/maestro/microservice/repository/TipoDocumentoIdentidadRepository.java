package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.TipoDocumentoIdentidad;

public interface TipoDocumentoIdentidadRepository  extends JpaRepository<TipoDocumentoIdentidad, Integer> {
}
