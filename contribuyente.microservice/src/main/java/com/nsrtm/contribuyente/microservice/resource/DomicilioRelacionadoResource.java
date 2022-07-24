package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.service.DomicilioContribuyenteService;
import com.nsrtm.contribuyente.microservice.service.DomicilioRelacionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domiciliorelacionado")
public class DomicilioRelacionadoResource {
    @Autowired
    private DomicilioRelacionadoService domicilioRelacionadoService;

    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Guardar(@RequestBody RelacionadoCustom domicilio) {
        //if(domicilio.domicilioRelacionadoNumero == null)
            //return domicilioRelacionadoService.Crear(domicilio);
       // else
            return domicilioRelacionadoService.Actualizar(domicilio);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioRelacionado ObtenerPorId(Long municipalidadId,Long contribuyenteNumero,Long relContribuyenteNumero) {
        return domicilioRelacionadoService.ObtenerPorId(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
    }

}
