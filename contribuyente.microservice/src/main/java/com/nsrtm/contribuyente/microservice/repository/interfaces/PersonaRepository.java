package com.nsrtm.contribuyente.microservice.repository.interfaces;

import com.nsrtm.contribuyente.microservice.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonaRepository extends JpaRepository<Persona, Long>, JpaSpecificationExecutor {
}
