package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.*;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.repository.interfaces.RelacionadoRepository;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionadoService {
    private static final Logger logger = LogManager.getLogger(RelacionadoService.class);

    @Autowired
    private RelacionadoRepository relacionadoRepository;

    public ResponseEntity<Object> Crear(RelacionadoCustom e){
        return relacionadoRepository.CrearRelacionado(e);
    }

    public ResponseEntity<Object> Actualizar(RelacionadoCustom e){
        return relacionadoRepository.ActualizarRelacionado(e);
    }

    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero){
        RelacionadoId id = new RelacionadoId(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
        relacionadoRepository.deleteById(id);
        return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
    }

    public Relacionado ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero) {
        try {
            RelacionadoId id = new RelacionadoId(municipalidadId,contribuyenteNumero,relContribuyenteNumero);
            return relacionadoRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Relacionado> Todos(){
        return relacionadoRepository.findAll();
    }
}
