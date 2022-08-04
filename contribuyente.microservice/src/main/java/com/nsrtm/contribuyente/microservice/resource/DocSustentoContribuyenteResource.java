package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyente;
import com.nsrtm.contribuyente.microservice.service.DocSustentoContribuyenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/docsustento")
public class DocSustentoContribuyenteResource {
    @Autowired
    private DocSustentoContribuyenteService docSustentoService;

    @GetMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<DocSustentoContribuyente> ObtenerLista(Long municipalidadId, Long contribuyenteNumero){
        return docSustentoService.ObtenerLista(municipalidadId,contribuyenteNumero);
    }
}