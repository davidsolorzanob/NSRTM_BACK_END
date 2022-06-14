package com.nsrtm.maestro.microservice.service;

import com.nsrtm.maestro.microservice.domain.EstadoCivil;
import com.nsrtm.maestro.microservice.repository.EstadoCivilRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstadoCivilService {
    private static final Logger logger = LogManager.getLogger(MaestroService.class);
    @Autowired
    private EstadoCivilRepository estadoCivilRepository;
    public void Guardar(EstadoCivil e) {
        try
        {
            estadoCivilRepository.save(e);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
    public void Actualizar(EstadoCivil e){
        try {
            EstadoCivil tipoDb = ObtenerPorId(e.estadoCivilId);
            tipoDb.descripcion = e.descripcion;
            Guardar(tipoDb);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
    public void Eliminar(Integer id){
        try {
            estadoCivilRepository.deleteById(id);
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
    public EstadoCivil ObtenerPorId (Integer id) {
        try{
            return estadoCivilRepository.findById(id).get();
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
    public List<EstadoCivil> ObtenerPorFiltro (EstadoCivil e) {
        try{
            EstadoCivil m = EstadoCivil.builder().estadoCivilId(e.estadoCivilId).build();
            return estadoCivilRepository.findAll(Example.of(m));
        }
        catch (Exception ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
    public List<EstadoCivil> Todos(){
        return estadoCivilRepository.findAll();
    }
}