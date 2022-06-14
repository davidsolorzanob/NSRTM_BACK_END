package com.nsrtm.maestro.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.maestro.microservice.domain.ModalidadOficio;

public interface ModalidadOficioRepository  extends JpaRepository<ModalidadOficio, Integer> {
}
