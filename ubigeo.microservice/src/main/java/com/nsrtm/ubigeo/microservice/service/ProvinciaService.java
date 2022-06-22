package com.nsrtm.ubigeo.microservice.service;

import com.nsrtm.ubigeo.microservice.domain.Provincia;
import com.nsrtm.ubigeo.microservice.domain.ProvinciaId;
import com.nsrtm.ubigeo.microservice.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
            Provincia provincia = ObtenerPorId(e.departamentoId,e.provinciaId);
            Guardar(provincia);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long idProvincia, Long idDepartamento){
        try{
            ProvinciaId id = new ProvinciaId(idDepartamento,idProvincia);
            provinciaRepository.deleteById(id);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Provincia ObtenerPorId(Long idProvincia, Long idDepartamento){
        try {
            ProvinciaId id = new ProvinciaId(idDepartamento,idProvincia);
            return provinciaRepository.findById(id).get();
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Provincia> FiltrarPorDepartamento(Long idDepartamento){
        Specification<Provincia> spec = Specification.where(getDepartamento(idDepartamento));
        if(spec == null)
            return null;
        return provinciaRepository.findAll(spec);
    }

    private static Specification<Provincia> getDepartamento(Long idDepartamento) {
        if(idDepartamento == null || idDepartamento ==0) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("departamentoId"),idDepartamento);
    }

    public List<Provincia> Todos(){
        return provinciaRepository.findAll();
    }


}
