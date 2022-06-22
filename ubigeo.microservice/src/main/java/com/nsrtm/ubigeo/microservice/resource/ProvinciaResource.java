package com.nsrtm.ubigeo.microservice.resource;

import com.nsrtm.ubigeo.microservice.domain.Provincia;
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
    public void Eliminar(Long idDepartamento, Long idProvincia) {
        provinciaService.Eliminar(idDepartamento,idProvincia);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Provincia ObtenerPorId(Long idDepartamento, Long idProvincia) {
        return provinciaService.ObtenerPorId(idDepartamento,idProvincia);
    }

    @GetMapping("filtrarpordepartamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Provincia>  FiltrarPorDepartamento(Long idDepartamento) {
        return provinciaService.FiltrarPorDepartamento(idDepartamento);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Provincia> Todos() {
        return provinciaService.Todos();
    }
}
