package com.nsrtm.via.microservice.resource;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;
import com.nsrtm.via.microservice.service.ZonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zona")
public class ZonaResource {
    @Autowired
    private ZonaService zonaService;

    @PostMapping("listarZona")
    @ResponseStatus(HttpStatus.OK)
    public List<Ubicacion> ListarZona(@RequestBody Ubicacion ubicacion) {
        return zonaService.ListaZonaUrbana(ubicacion);
    }

    @PostMapping("listarSubZona")
    @ResponseStatus(HttpStatus.OK)
    public List<Ubicacion> ListarSubZona(@RequestBody Ubicacion ubicacion) {
        return zonaService.ListaSubZonaUrbana(ubicacion);
    }
}
