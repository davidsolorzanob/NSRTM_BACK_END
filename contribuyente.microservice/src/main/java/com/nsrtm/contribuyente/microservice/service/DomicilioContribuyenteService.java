package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.repository.DomicilioContribuyenteRepository;
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
        return domicilioContribuyenteRepository.CrearDomicilioContribuyente(e);
    }

    public ResponseEntity<Object> Actualizar(DomicilioContribuyente e){
        return domicilioContribuyenteRepository.ActualizarDomicilioContribuyente(e);
    }

    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero) {
        try {
            DomicilioContribuyenteId id = new DomicilioContribuyenteId(municipalidadId,contribuyenteNumero,domicilioContribuyenteNumero);
            domicilioContribuyenteRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public DomicilioContribuyente ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero) {
        try {
            DomicilioContribuyenteId id = new DomicilioContribuyenteId(municipalidadId,contribuyenteNumero,domicilioContribuyenteNumero);
            return domicilioContribuyenteRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<DomicilioContribuyente> Todos(){
        return domicilioContribuyenteRepository.findAll();
    }
}
