package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import org.springframework.http.ResponseEntity;

public interface CondicionContribuyenteCustomRepository {
    CondicionContribuyenteCustom CrearCondicionContribuyente(CondicionContribuyenteCustom custom);
    CondicionContribuyenteCustom ActualizarCondicionContribuyente(CondicionContribuyenteCustom custom);
    CondicionContribuyenteCustom ObtenerCondicionContribuyente(Long municipalidadId, Long contribuyenteNumero);
}