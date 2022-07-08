package com.nsrtm.contribuyente.microservice.repository.interfaces;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteTipo;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteTipoId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioContribuyenteTipoRepository extends JpaRepository<DomicilioContribuyenteTipo, DomicilioContribuyenteTipoId> {

}