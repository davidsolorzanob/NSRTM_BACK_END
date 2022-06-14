package com.nsrtm.maestro.microservice.repository;

import com.nsrtm.maestro.microservice.domain.Edificacion;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EdificacionRepository  extends JpaRepository<Edificacion, Integer> {
}
