package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.service.RelacionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/relacionado")
public class RelacionadoResource {

    @Autowired
    private RelacionadoService relacionadoService;

    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Guardar (@RequestBody RelacionadoCustom relacionado) {
        if(relacionado.relContribuyenteNumero != null)
            return relacionadoService.Crear(relacionado);
        else
            return relacionadoService.Actualizar(relacionado);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero) {
        return relacionadoService.Eliminar(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
    }

    @GetMapping("obtener")
    @ResponseStatus(HttpStatus.OK)
    public Relacionado ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero){
        return relacionadoService.ObtenerPorId(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
    }

    @GetMapping("todos")
    @ResponseStatus(HttpStatus.OK)
    public List<Relacionado> Todos() {
        return relacionadoService.Todos();
    }
}
