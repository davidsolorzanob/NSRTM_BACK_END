package com.nsrtm.via.microservice.resource;

import com.nsrtm.via.microservice.domain.Via;
import com.nsrtm.via.microservice.service.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/via")
public class ViaResource {
    @Autowired
    private ViaService viaService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Via via) {
        viaService.Guardar(via);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Via via) {
        viaService.Actualizar(via);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        viaService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Via ObtenerPorId(Long id) {
        return viaService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Via> Todos() {
        return viaService.Todos();
    }

}
