package com.nsrtm.ubigeo.microservice.resource;

import com.nsrtm.ubigeo.microservice.domain.Distrito;
import com.nsrtm.ubigeo.microservice.domain.Provincia;
import com.nsrtm.ubigeo.microservice.service.DistritoService;
import com.nsrtm.ubigeo.microservice.service.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaResource {
    @Autowired
    private ProvinciaService provinciaService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Provincia provincia) {
        provinciaService.Guardar(provincia);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Provincia provincia) {
        provinciaService.Actualizar(provincia);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        provinciaService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Provincia ObtenerPorId(Long id) {
        return provinciaService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Provincia> Todos() {
        return provinciaService.Todos();
    }
}
