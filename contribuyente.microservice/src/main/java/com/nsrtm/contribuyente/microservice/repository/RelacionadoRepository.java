package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RelacionadoRepository extends JpaRepository<Relacionado, Long> {
}