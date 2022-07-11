package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import org.springframework.http.ResponseEntity;

public interface CondicionContribuyenteCustomRepository {
    ResponseEntity<Object> CrearCondicionContribuyente(CondicionContribuyenteCustom custom);
    ResponseEntity<Object> ActualizarCondicionContribuyente(CondicionContribuyenteCustom custom);
}