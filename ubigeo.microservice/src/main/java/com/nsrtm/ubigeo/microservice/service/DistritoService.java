package com.nsrtm.ubigeo.microservice.service;

import com.nsrtm.ubigeo.microservice.domain.Distrito;
import com.nsrtm.ubigeo.microservice.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistritoService {
    //private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private DistritoRepository distritoRepository;

    public void Guardar(Distrito e) {
        try{
            distritoRepository.save(e);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(Distrito e){
        try {
            Distrito distrito = ObtenerPorId(e.distritoId);
            Guardar(distrito);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long id){
        try{
            distritoRepository.deleteById(id);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Distrito ObtenerPorId(Long id) {
        try {
            return distritoRepository.findById(id).get();
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Distrito> Todos(){
        return distritoRepository.findAll();
    }
}
