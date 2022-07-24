package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import org.springframework.http.ResponseEntity;

public interface DomicilioRelacionadoCustomRepository {
    RelacionadoCustom CrearDomicilioRelacionado(RelacionadoCustom custom);
    ResponseEntity<Object> ActualizarDomicilioRelacionado(RelacionadoCustom custom);
    DomicilioRelacionado ObtenerDomicilioRelacionado(Long municipalidadId, Long contribuyenteNumero, Long relcontribuyenteNumero);
}