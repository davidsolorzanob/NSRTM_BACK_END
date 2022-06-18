package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRelacionadoRepository extends JpaRepository<DomicilioRelacionado, Long> {
}