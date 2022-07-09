package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import org.springframework.http.ResponseEntity;

public interface DomicilioRelacionadoCustomRepository {
    ResponseEntity<Object> CrearDomicilioRelacionado(DomicilioRelacionado custom);
    ResponseEntity<Object> ActualizarDomicilioRelacionado(DomicilioRelacionado custom);
}