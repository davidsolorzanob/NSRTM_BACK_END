package com.nsrtm.via.microservice.resource;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;
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

    @PostMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<Ubicacion> ListarVia(@RequestBody Ubicacion ubicacion) {
        return viaService.ListaVia(ubicacion);
    }
}
