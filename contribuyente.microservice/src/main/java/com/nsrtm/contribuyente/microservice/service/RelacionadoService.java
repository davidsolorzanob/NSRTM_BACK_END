package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.*;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.repository.DomicilioRelacionadoRepository;
import com.nsrtm.contribuyente.microservice.repository.RelacionadoRepository;
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

    @Autowired
    private DomicilioRelacionadoRepository domicilioRelacionadoRepository;

    public ResponseEntity<Object> Crear(Relacionado e) {
        Relacionado rel = relacionadoRepository.CrearRelacionado(e);
        //DomicilioRelacionado dom = e.domicilioRelacionado.get(0);

        if (rel.relContribuyenteNumero != null) {
            e.relContribuyenteNumero = rel.relContribuyenteNumero;
            rel = domicilioRelacionadoRepository.CrearDomicilioRelacionado(e);
        }
        return MessageResponse.setResponse(true,"El relacionado y su domicilio se registró correctamente", rel);
    }

    public ResponseEntity<Object> Actualizar(Relacionado e){
        return relacionadoRepository.ActualizarRelacionado(e);
    }

    public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ, Long relContribuyenteNumero){
        RelacionadoId id = new RelacionadoId(municipalidadId,contribuyenteNumero,numeroDJ,relContribuyenteNumero);
        relacionadoRepository.deleteById(id);
        return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
    }

    public Relacionado ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        return relacionadoRepository.ObtenerRelacionado(municipalidadId,contribuyenteNumero,numeroDJ);
    }

    public RelacionadoCustom ObtenerConDomicilioPorId(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        return relacionadoRepository.ObtenerRelacionadoConDomicilio(municipalidadId,contribuyenteNumero, numeroDJ);
    }

    public List<TipoRelacionado> ListarTipoRelacionado(Integer tipo){
        return relacionadoRepository.ListaTipoRelacionado(tipo);
    }

    public List<Relacionado> Todos(){
        return relacionadoRepository.findAll();
    }
}
