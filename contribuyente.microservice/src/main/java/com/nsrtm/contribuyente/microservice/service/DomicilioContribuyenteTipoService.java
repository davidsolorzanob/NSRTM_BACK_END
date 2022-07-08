package com.nsrtm.contribuyente.microservice.service;

import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteTipo;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyenteTipoId;
import com.nsrtm.contribuyente.microservice.repository.interfaces.DomicilioContribuyenteTipoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DomicilioContribuyenteTipoService {
    private static final Logger logger = LogManager.getLogger(DomicilioContribuyenteTipoService.class);

    @Autowired
    private DomicilioContribuyenteTipoRepository domicilioContribuyenteTipoRepository;

    public void Guardar(DomicilioContribuyenteTipo e) {
        try{
            domicilioContribuyenteTipoRepository.save(e);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(DomicilioContribuyenteTipo e){
        try {
            DomicilioContribuyenteTipo contribuyente = ObtenerPorId(e.municipalidadId, e.contribuyenteNumero,e.domicilioContribuyenteNumero,e.tipoDomicilioId);
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

    public void Eliminar(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero, Long tipoDomicilioId) {
        try{
            DomicilioContribuyenteTipoId id =new DomicilioContribuyenteTipoId(municipalidadId, contribuyenteNumero,domicilioContribuyenteNumero,tipoDomicilioId);
            domicilioContribuyenteTipoRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public DomicilioContribuyenteTipo ObtenerPorId(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero, Long tipoDomicilioId) {
        try {
            DomicilioContribuyenteTipoId id =new DomicilioContribuyenteTipoId(municipalidadId, contribuyenteNumero,domicilioContribuyenteNumero,tipoDomicilioId);
            return domicilioContribuyenteTipoRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<DomicilioContribuyenteTipo> Todos(){
        return domicilioContribuyenteTipoRepository.findAll();
    }
}
