package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.repository.DomicilioContribuyenteRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DomicilioContribuyenteService {
    private static final Logger logger = LogManager.getLogger(DomicilioContribuyenteService.class);

    @Autowired
    private DomicilioContribuyenteRepository domicilioContribuyenteRepository;

    public void Guardar(DomicilioContribuyente e) {
        try{
            domicilioContribuyenteRepository.save(e);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(DomicilioContribuyente e){
        try {
            DomicilioContribuyente contribuyente = ObtenerPorId(e.domicilioContribuyenteNumero);
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

    public void Eliminar(Long id){
        try{
            domicilioContribuyenteRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public DomicilioContribuyente ObtenerPorId(Long id) {
        try {
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
