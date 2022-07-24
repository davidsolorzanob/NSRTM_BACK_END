package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionadoId;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.repository.DomicilioRelacionadoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioRelacionadoService {
    private static final Logger logger = LogManager.getLogger(DomicilioRelacionadoService.class);

    @Autowired
    private DomicilioRelacionadoRepository domicilioRelacionadoRepository;


    public RelacionadoCustom Crear(RelacionadoCustom e){
        return domicilioRelacionadoRepository.CrearDomicilioRelacionado(e);
    }

    public ResponseEntity<Object> Actualizar(RelacionadoCustom e){
        return domicilioRelacionadoRepository.ActualizarDomicilioRelacionado(e);
    }

    public DomicilioRelacionado ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero) {
        return domicilioRelacionadoRepository.ObtenerDomicilioRelacionado(municipalidadId, contribuyenteNumero, relContribuyenteNumero);
    }
}
