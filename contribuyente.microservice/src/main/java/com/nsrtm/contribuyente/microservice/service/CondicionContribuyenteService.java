package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.CondicionContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.repository.CondicionContribuyenteRepository;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CondicionContribuyenteService {
    private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private CondicionContribuyenteRepository condicionContribuyenteRepository;

    public ResponseEntity<Object> Crear(CondicionContribuyenteCustom e){
        condicionContribuyenteRepository.CrearCondicionContribuyente(e);
        return MessageResponse.setResponse(true, "El registro de la condición del contribuyente se guardó satisfactoriamente");
    }

    public CondicionContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero){
        return condicionContribuyenteRepository.ObtenerCondicionContribuyente(municipalidadId,contribuyenteNumero);
    }

    public ResponseEntity<Object> Actualizar(CondicionContribuyenteCustom e){
        condicionContribuyenteRepository.ActualizarCondicionContribuyente(e);
        return MessageResponse.setResponse(true, "El registro de la condición del contribuyente se actualizó satisfactoriamente");
    }

    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long conContribuyenteId){
        CondicionContribuyenteId id = new CondicionContribuyenteId(municipalidadId,contribuyenteNumero,conContribuyenteId);
        condicionContribuyenteRepository.deleteById(id);
        return MessageResponse.setResponse(true, "El registro de la condición del contribuyente se eliminó satisfactoriamente");
    }
}
