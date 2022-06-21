package com.nsrtm.ubigeo.microservice.repository;

import com.nsrtm.ubigeo.microservice.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long>, JpaSpecificationExecutor {

}