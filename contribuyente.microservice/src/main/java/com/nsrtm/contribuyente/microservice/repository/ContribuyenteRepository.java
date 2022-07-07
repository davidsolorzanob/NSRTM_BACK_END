package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, ContribuyenteId>, JpaSpecificationExecutor, ContribuyenteCustomRepository {

}
