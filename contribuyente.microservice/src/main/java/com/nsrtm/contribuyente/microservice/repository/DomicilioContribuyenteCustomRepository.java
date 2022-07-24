package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import org.springframework.http.ResponseEntity;

public interface DomicilioContribuyenteCustomRepository {
    DomicilioContribuyente CrearDomicilioContribuyente(DomicilioContribuyente custom);
    DomicilioContribuyente ActualizarDomicilioContribuyente(DomicilioContribuyente custom);
}
