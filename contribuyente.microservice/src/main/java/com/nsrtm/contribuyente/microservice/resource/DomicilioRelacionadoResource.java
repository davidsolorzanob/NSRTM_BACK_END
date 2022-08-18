package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.service.DomicilioRelacionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/domiciliorelacionado")
public class DomicilioRelacionadoResource {
    @Autowired
    private DomicilioRelacionadoService domicilioRelacionadoService;

    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Guardar(@RequestBody Relacionado domicilio) {
        //if(domicilio.domicilioRelacionadoNumero == null)
            //return domicilioRelacionadoService.Crear(domicilio);
       // else
            return domicilioRelacionadoService.Actualizar(domicilio);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioRelacionado ObtenerPorId(Long municipalidadId,Long contribuyenteNumero,Long numeroDJ, Long relContribuyenteNumero) {
        return domicilioRelacionadoService.ObtenerPorId(municipalidadId,contribuyenteNumero, numeroDJ, relContribuyenteNumero);
    }

}
