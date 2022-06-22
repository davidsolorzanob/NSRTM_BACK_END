package com.nsrtm.ubigeo.microservice.repository;

import com.nsrtm.ubigeo.microservice.domain.Distrito;
import com.nsrtm.ubigeo.microservice.domain.DistritoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DistritoRepository extends JpaRepository<Distrito, DistritoId>, JpaSpecificationExecutor {

}