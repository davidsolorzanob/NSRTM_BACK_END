package com.nsrtm.contribuyente.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;

public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Long> {

}
