package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.service.CondicionContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CondicionContribuyenteResource {
    @Autowired
    private CondicionContribuyenteService condicionContribuyenteService;

    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Guardar (@RequestBody CondicionContribuyenteCustom condicion) {
        if(condicion.conContribuyenteId == null)
            return condicionContribuyenteService.Crear(condicion);
        else
            return condicionContribuyenteService.Actualizar(condicion);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long conContribuyenteId) {
        return condicionContribuyenteService.Eliminar(municipalidadId, contribuyenteNumero, conContribuyenteId);
    }
}
