package com.nsrtm.maestro.microservice.resource;

import com.nsrtm.maestro.microservice.domain.EstadoCivil;
import com.nsrtm.maestro.microservice.service.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estadocivil")
public class EstadoCivilResource {
    @Autowired
    private EstadoCivilService estadoCivilService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody EstadoCivil e) {
        estadoCivilService.Guardar(e);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody EstadoCivil e) {
        estadoCivilService.Actualizar(e);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Integer id) {
        estadoCivilService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public EstadoCivil ObtenerPorId(Integer id) {
        return estadoCivilService.ObtenerPorId(id);
    }

    @PostMapping("filtrar")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadoCivil> Filtrar(@RequestBody EstadoCivil e) {
        return estadoCivilService.ObtenerPorFiltro(e);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<EstadoCivil> Todos() {
        return estadoCivilService.Todos();
    }
}
