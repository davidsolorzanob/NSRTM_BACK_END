package com.nsrtm.ubigeo.microservice.service;

import com.nsrtm.ubigeo.microservice.domain.Provincia;
import com.nsrtm.ubigeo.microservice.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinciaService {
    //private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public void Guardar(Provincia e) {
        try{
            provinciaRepository.save(e);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(Provincia e){
        try {
            Provincia provincia = ObtenerPorId(e.provinciaId);
            Guardar(provincia);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long id){
        try{
            provinciaRepository.deleteById(id);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Provincia ObtenerPorId(Long id) {
        try {
            return provinciaRepository.findById(id).get();
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Provincia> Todos(){
        return provinciaRepository.findAll();
    }
}
