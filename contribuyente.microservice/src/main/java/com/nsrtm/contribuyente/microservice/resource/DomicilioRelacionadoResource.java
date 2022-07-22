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
/*
    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero, Long domicilioRelacionadoNumero ) {
        domicilioRelacionadoService.Eliminar(municipalidadId,contribuyenteNumero,relContribuyenteNumero,domicilioRelacionadoNumero);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioRelacionado ObtenerPorId(Long municipalidadId,Long contribuyenteNumero,Long relContribuyenteNumero,Long domicilioRelacionadoNumero) {
        return domicilioRelacionadoService.ObtenerPorId(municipalidadId,contribuyenteNumero,relContribuyenteNumero,domicilioRelacionadoNumero);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioRelacionado> Todos() {
        return domicilioRelacionadoService.Todos();
    }
    */
}
