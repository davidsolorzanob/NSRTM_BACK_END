package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import org.springframework.http.ResponseEntity;

public interface DomicilioRelacionadoCustomRepository {
    DomicilioRelacionado CrearDomicilioRelacionado(DomicilioRelacionado custom);
    ResponseEntity<Object> ActualizarDomicilioRelacionado(DomicilioRelacionado custom);
}