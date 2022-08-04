package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;
import com.nsrtm.contribuyente.microservice.repository.ContactoContribuyenteRepository;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private ContactoContribuyenteRepository contactoContribuyenteRepository;

    public ResponseEntity<Object> CrearContacto(ContactoContribuyente e) {
        e = contactoContribuyenteRepository.CrearContacto(e);
        return MessageResponse.setResponse(true,"El contacto del contribuyente se registró correctamente", e);
    }

    public ResponseEntity<Object> ActualizarContacto(ContactoContribuyente e){
        e = contactoContribuyenteRepository.ActualizarContacto(e);
        return MessageResponse.setResponse(true,"El contacto del contribuyente se actualizó correctamente", e);
    }

    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long contactoContribuyenteId, Long usuario, String terminal){
        contactoContribuyenteRepository.EliminarContacto(municipalidadId, contribuyenteNumero, contactoContribuyenteId, usuario, terminal);
        return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
    }

    public List<ContactoContribuyente> ObtenerLista(Long municipalidadId, Long contribuyenteNumero){
        return contactoContribuyenteRepository.ListaContacto(municipalidadId, contribuyenteNumero);
    }
}
