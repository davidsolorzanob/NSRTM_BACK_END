package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.service.DomicilioRelacionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domiciliorelacionado")
public class DomicilioRelacionadoResource {
    @Autowired
    private DomicilioRelacionadoService domicilioRelacionadoService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody DomicilioRelacionado domRelacionado) {
        domicilioRelacionadoService.Guardar(domRelacionado);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody DomicilioRelacionado domRelacionado) {
        domicilioRelacionadoService.Actualizar(domRelacionado);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long municipalidadId,Long contribuyenteNumero,Long relContribuyenteNumero,Long domicilioRelacionadoNumero) {
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
}
