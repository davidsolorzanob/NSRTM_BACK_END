package com.nsrtm.via.microservice.resource;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;
import com.nsrtm.via.microservice.service.EdificacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/edificacion")
public class EdificacionResource {
    @Autowired
    private EdificacionService edificacionService;

    @PostMapping("listarEdificacion")
    @ResponseStatus(HttpStatus.OK)
    public List<Ubicacion> ListarEdificacion(@RequestBody Ubicacion ubicacion) {
        return edificacionService.ListaEdificacion(ubicacion);
    }
}
