package com.nsrtm.ubigeo.microservice.resource;

import com.nsrtm.ubigeo.microservice.domain.Departamento;
import com.nsrtm.ubigeo.microservice.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamento")
public class DepartamentoResource {
    @Autowired
    private DepartamentoService departamentoService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Departamento departamento) {
        departamentoService.Guardar(departamento);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Departamento departamento) {
        departamentoService.Actualizar(departamento);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long id) {
        departamentoService.Eliminar(id);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Departamento ObtenerPorId(Long id) {
        return departamentoService.ObtenerPorId(id);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Departamento> Todos() {
        return departamentoService.Todos();
    }
}
