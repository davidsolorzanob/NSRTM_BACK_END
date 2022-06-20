package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteTipo;
import com.nsrtm.contribuyente.microservice.service.DomicilioContribuyenteTipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domiciliocontribuyentetipo")
public class DomicilioContribuyenteTipoResource {

    @Autowired
    private DomicilioContribuyenteTipoService domicilioContribuyenteTipoService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody DomicilioContribuyenteTipo domicilioContribuyenteTipo) {
        domicilioContribuyenteTipoService.Guardar(domicilioContribuyenteTipo);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody DomicilioContribuyenteTipo domicilioContribuyenteTipo) {
        domicilioContribuyenteTipoService.Actualizar(domicilioContribuyenteTipo);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        domicilioContribuyenteTipoService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public DomicilioContribuyenteTipo ObtenerPorId(Long id) {
        return domicilioContribuyenteTipoService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<DomicilioContribuyenteTipo> Todos() {
        return domicilioContribuyenteTipoService.Todos();
    }
}
