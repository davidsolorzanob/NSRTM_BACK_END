package com.nsrtm.contribuyente.microservice.resource;

import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;
import com.nsrtm.contribuyente.microservice.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacto")
public class ContactoContribuyenteResource {
    @Autowired
    private ContactoService contactoService;

    @GetMapping("listar")
    @ResponseStatus(HttpStatus.OK)
    public List<ContactoContribuyente> ObtenerLista(Long municipalidadId, Long contribuyenteNumero){
        return contactoService.ObtenerLista(municipalidadId,contribuyenteNumero);
    }
}
