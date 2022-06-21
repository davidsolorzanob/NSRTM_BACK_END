package com.nsrtm.ubigeo.microservice.repository;

import com.nsrtm.ubigeo.microservice.domain.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProvinciaRepository extends JpaRepository<Provincia, Long>, JpaSpecificationExecutor {

}