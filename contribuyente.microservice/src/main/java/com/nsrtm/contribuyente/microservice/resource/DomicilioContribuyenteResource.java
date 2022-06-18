package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.service.DomicilioContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domiciliocontribuyente")
public class DomicilioContribuyenteResource {
    @Autowired
    private DomicilioContribuyenteService domicilioContribuyenteService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody DomicilioContribuyente contribuyente) {
        domicilioContribuyenteService.Guardar(contribuyente);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody DomicilioContribuyente contribuyente) {
        domicilioContribuyenteService.Actualizar(contribuyente);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        domicilioContribuyenteService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioContribuyente ObtenerPorId(Long id) {
        return domicilioContribuyenteService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioContribuyente> Todos() {
        return domicilioContribuyenteService.Todos();
    }
}
