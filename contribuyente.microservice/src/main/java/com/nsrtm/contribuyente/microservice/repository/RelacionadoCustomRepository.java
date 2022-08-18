package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.TipoRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RelacionadoCustomRepository {
    Relacionado CrearRelacionado(Relacionado custom);
    ResponseEntity<Object> ActualizarRelacionado(Relacionado custom);
    List<TipoRelacionado> ListaTipoRelacionado(Integer tipo);
    Relacionado ObtenerRelacionado(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ);
    RelacionadoCustom ObtenerRelacionadoConDomicilio(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ);
}
