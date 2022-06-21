package com.nsrtm.ubigeo.microservice.service;

import com.nsrtm.ubigeo.microservice.domain.Departamento;
import com.nsrtm.ubigeo.microservice.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {
    //private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public void Guardar(Departamento e) {
        try{
            departamentoRepository.save(e);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Actualizar(Departamento e){
        try {
            Departamento departamento = ObtenerPorId(e.departamentoId);
            Guardar(departamento);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long id){
        try{
            departamentoRepository.deleteById(id);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Departamento ObtenerPorId(Long id) {
        try {
            return departamentoRepository.findById(id).get();
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Departamento> Todos(){
        return departamentoRepository.findAll();
    }
}
