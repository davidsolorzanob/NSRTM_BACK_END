package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import org.springframework.http.ResponseEntity;

public interface DomicilioContribuyenteCustomRepository {
    ResponseEntity<Object> CrearDomicilioContribuyente(DomicilioContribuyente custom);
    ResponseEntity<Object> ActualizarDomicilioContribuyente(DomicilioContribuyente custom);
}
