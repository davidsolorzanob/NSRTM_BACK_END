package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.complex.DomicilioContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.service.DomicilioContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domiciliocontribuyente")
public class DomicilioContribuyenteResource {
    @Autowired
    private DomicilioContribuyenteService domicilioContribuyenteService;

    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Guardar(@RequestBody DomicilioContribuyente domicilio) {
        if(domicilio.domicilioContribuyenteNumero == null)
            return domicilioContribuyenteService.Crear(domicilio);
        else
            return domicilioContribuyenteService.Actualizar(domicilio);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero ) {
        domicilioContribuyenteService.Eliminar(municipalidadId,contribuyenteNumero,domicilioContribuyenteNumero);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
        return domicilioContribuyenteService.ObtenerPorId(municipalidadId,contribuyenteNumero);
    }

    @GetMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioContribuyenteCustom> ObtenerLista(Long municipalidadId, Long contribuyenteNumero){
        return domicilioContribuyenteService.ObtenerLista(municipalidadId,contribuyenteNumero);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioContribuyente> Todos() {
        return domicilioContribuyenteService.Todos();
    }
}
