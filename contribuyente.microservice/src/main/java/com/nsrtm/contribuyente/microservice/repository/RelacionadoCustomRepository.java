package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.TipoRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RelacionadoCustomRepository {
    RelacionadoCustom CrearRelacionado(RelacionadoCustom custom);
    ResponseEntity<Object> ActualizarRelacionado(RelacionadoCustom custom);
    List<TipoRelacionado> ListaTipoRelacionado(Integer tipo);
}
