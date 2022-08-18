package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.complex.DomicilioContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.repository.DomicilioContribuyenteRepository;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioContribuyenteService {
    private static final Logger logger = LogManager.getLogger(DomicilioContribuyenteService.class);

    @Autowired
    private DomicilioContribuyenteRepository domicilioContribuyenteRepository;

    public ResponseEntity<Object> Crear(DomicilioContribuyente e){
        e = domicilioContribuyenteRepository.CrearDomicilioContribuyente(e);
        return MessageResponse.setResponse(true,"El domicilio del contribuyente se registró correctamente", e);
    }

    public ResponseEntity<Object> Actualizar(DomicilioContribuyente e){
        domicilioContribuyenteRepository.ActualizarDomicilioContribuyente(e);
        return MessageResponse.setResponse(true,"El domicilio del contribuyente se actualizó correctamente", e);
    }

    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ, Long domicilioContribuyenteNumero) {
        try {
            DomicilioContribuyenteId id = new DomicilioContribuyenteId(municipalidadId,contribuyenteNumero,numeroDJ,domicilioContribuyenteNumero);
            domicilioContribuyenteRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public DomicilioContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        return domicilioContribuyenteRepository.ObtenerDomicilioContribuyente(municipalidadId, contribuyenteNumero, numeroDJ);
    }

    public List<DomicilioContribuyenteCustom> ObtenerLista(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ){
        return domicilioContribuyenteRepository.ListaDomicilioContribuyente(municipalidadId, contribuyenteNumero, numeroDJ);
    }

    public List<DomicilioContribuyente> Todos(){
        return domicilioContribuyenteRepository.findAll();
    }
}
