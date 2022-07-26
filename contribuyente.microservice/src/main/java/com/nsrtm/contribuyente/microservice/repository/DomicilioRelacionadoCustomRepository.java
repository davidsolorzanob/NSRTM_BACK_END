package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import org.springframework.http.ResponseEntity;

public interface DomicilioRelacionadoCustomRepository {
    Relacionado CrearDomicilioRelacionado(Relacionado custom);
    ResponseEntity<Object> ActualizarDomicilioRelacionado(Relacionado custom);
    DomicilioRelacionado ObtenerDomicilioRelacionado(Long municipalidadId, Long contribuyenteNumero, Long relcontribuyenteNumero);
}