package com.nsrtm.via.microservice.service;

import com.nsrtm.via.microservice.domain.Via;
import com.nsrtm.via.microservice.repository.ViaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaService {
    private static final Logger logger = LogManager.getLogger(ViaService.class);

    @Autowired
    private ViaRepository viaRepository;

    public void Guardar(Via e) {
        try{
            viaRepository.save(e);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(Via e){
        try {
            Via tipoDb = ObtenerPorId(e.viaId);
            tipoDb.baseLegalId = e.baseLegalId;
            tipoDb.secEjec = e.secEjec;
            tipoDb.codigoVia = e.codigoVia;
            tipoDb.tipoVia = e.tipoVia;
            tipoDb.nombreVia = e.nombreVia;
            tipoDb.situacionVia = e.situacionVia;
            tipoDb.tramoInicio = e.tramoInicio;
            tipoDb.tramoFin = e.tramoFin;
            tipoDb.situacion = e.situacion;
            tipoDb.alias = e.alias;
            tipoDb.estado = e.estado;
            Guardar(tipoDb);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long id){
        try{
            viaRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Via ObtenerPorId(Long id) {
        try {
            return viaRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Via> Todos(){
        return viaRepository.findAll();
    }
}
