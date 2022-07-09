package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioContribuyenteRepository extends JpaRepository<DomicilioContribuyente, DomicilioContribuyenteId>, DomicilioContribuyenteCustomRepository {

}