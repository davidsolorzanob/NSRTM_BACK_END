package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.service.RelacionadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/relacionado")
public class RelacionadoResource {

    @Autowired
    private RelacionadoService relacionadoService;

    @PostMapping("crear")
    @ResponseStatus(HttpStatus.OK)
    public void Crear(@RequestBody Relacionado relacionado) {
        relacionadoService.Guardar(relacionado);
    }

    @PostMapping("editar")
    @ResponseStatus(HttpStatus.OK)
    public void Editar(@RequestBody Relacionado relacionado) {
        relacionadoService.Actualizar(relacionado);
    }

    @PostMapping("eliminar")
    @ResponseStatus(HttpStatus.OK)
    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero) {
        relacionadoService.Eliminar(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
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
