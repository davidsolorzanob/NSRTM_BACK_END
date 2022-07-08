package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionadoId;
import com.nsrtm.contribuyente.microservice.repository.interfaces.DomicilioRelacionadoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioRelacionadoService {
    private static final Logger logger = LogManager.getLogger(DomicilioRelacionadoService.class);

    @Autowired
    private DomicilioRelacionadoRepository domicilioRelacionadoRepository;

    public void Guardar(DomicilioRelacionado e) {
        try{
            domicilioRelacionadoRepository.save(e);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(DomicilioRelacionado e){
        try {
            DomicilioRelacionado contribuyente = ObtenerPorId(e.municipalidadId,e.contribuyenteNumero,e.relContribuyenteNumero,e.domicilioRelacionadoNumero);
			/*
			contribuyente.contribuyenteId = e.contribuyenteId;
			contribuyente.secEjec = e.secEjec;
			contribuyente.tipoContribuyenteId = e.tipoContribuyenteId;
			contribuyente.numeroDocumento = e.numeroDocumento;
			contribuyente.apellidoPaterno = e.apellidoPaterno;
			contribuyente.apellidoMaterno = e.apellidoMaterno;
			contribuyente.nombres = e.nombres;
			contribuyente.razonSocial = e.razonSocial;
			contribuyente.celular1 = e.celular1;
			contribuyente.celular2 = e.celular2;
			contribuyente.correoElectronico1 = e.correoElectronico1;
			contribuyente.correoElectronico2 = e.correoElectronico2;

			 */
            Guardar(contribuyente);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long municipalidadId,Long contribuyenteNumero,Long relContribuyenteNumero,Long domicilioRelacionadoNumero) {
        try{
            DomicilioRelacionadoId id = new DomicilioRelacionadoId(municipalidadId,contribuyenteNumero,relContribuyenteNumero,domicilioRelacionadoNumero);
            domicilioRelacionadoRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public DomicilioRelacionado ObtenerPorId(Long municipalidadId,Long contribuyenteNumero,Long relContribuyenteNumero,Long domicilioRelacionadoNumero) {
        try {
            DomicilioRelacionadoId id = new DomicilioRelacionadoId(municipalidadId,contribuyenteNumero,relContribuyenteNumero,domicilioRelacionadoNumero);
            return domicilioRelacionadoRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<DomicilioRelacionado> Todos(){
        return domicilioRelacionadoRepository.findAll();
    }
}
