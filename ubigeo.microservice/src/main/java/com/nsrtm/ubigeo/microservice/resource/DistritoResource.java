package com.nsrtm.ubigeo.microservice.resource;

import com.nsrtm.ubigeo.microservice.domain.Distrito;
import com.nsrtm.ubigeo.microservice.domain.Provincia;
import com.nsrtm.ubigeo.microservice.service.DistritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/distrito")
public class DistritoResource {
    @Autowired
    private DistritoService distritoService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Distrito distrito) {
        distritoService.Guardar(distrito);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Distrito distrito) {
        distritoService.Actualizar(distrito);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long idDepartamento, Long idProvincia, Long idDistrito) {
        distritoService.Eliminar(idDepartamento,idProvincia,idDistrito);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Distrito ObtenerPorId(Long idDepartamento, Long idProvincia, Long idDistrito) {
        return distritoService.ObtenerPorId(idDepartamento,idProvincia,idDistrito);
    }

    @GetMapping("filtrarporprovincia")
    @ResponseStatus(HttpStatus.OK)
    public List<Distrito>  FiltrarPorProvincia(Long idDepartamento, Long idProvincia) {
        return distritoService.FiltrarPorProvincia(idDepartamento, idProvincia);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Distrito> Todos() {
        return distritoService.Todos();
    }
}
