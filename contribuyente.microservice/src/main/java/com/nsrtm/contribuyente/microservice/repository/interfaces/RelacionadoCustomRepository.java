package com.nsrtm.contribuyente.microservice.repository.interfaces;

import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import org.springframework.http.ResponseEntity;

public interface RelacionadoCustomRepository {
    ResponseEntity<Object> CrearRelacionado(RelacionadoCustom custom);
    ResponseEntity<Object> ActualizarRelacionado(RelacionadoCustom custom);
}
