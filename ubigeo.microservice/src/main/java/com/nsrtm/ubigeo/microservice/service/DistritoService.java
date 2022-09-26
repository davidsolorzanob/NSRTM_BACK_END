package com.nsrtm.ubigeo.microservice.service;

import com.nsrtm.ubigeo.microservice.domain.Distrito;
import com.nsrtm.ubigeo.microservice.domain.DistritoId;
import com.nsrtm.ubigeo.microservice.repository.DistritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
            Distrito distrito = ObtenerPorId(e.departamentoId, e.provinciaId, e.distritoId);
            Guardar(distrito);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public void Eliminar(Long idDepartamento, Long idProvincia,Long idDistrito) {
        try{
            DistritoId id = new DistritoId(idDepartamento, idProvincia, idDistrito);
            distritoRepository.deleteById(id);
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public Distrito ObtenerPorId(Long idDepartamento, Long idProvincia,Long idDistrito) {
        try {
            DistritoId id = new DistritoId(idDepartamento,idProvincia,idDistrito);
            return distritoRepository.findById(id).get();
        }
        catch (Exception ex){
            //logger.info(ex.getMessage());
            throw ex;
        }
    }

    public List<Distrito> FiltrarPorProvincia(Long idDepartamento, Long idProvincia){
        Specification<Distrito> spec = null;
        Specification<Distrito> specTemp = getDepartamento(idDepartamento);
        specTemp = specTemp==null ? getProvincia(idProvincia):specTemp.and(getProvincia(idProvincia));
        spec = Specification.where(specTemp);
        if(spec == null)
            return null;
        return distritoRepository.findAll(spec);
    }

    private static Specification<Distrito> getDepartamento(Long idDepartamento) {
        if(idDepartamento == null || idDepartamento ==0) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("departamentoId"),idDepartamento);
    }

    private static Specification<Distrito> getProvincia(Long idProvincia) {
        if(idProvincia == null || idProvincia ==0) return null;
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("provinciaId"),idProvincia);
    }

    public List<Distrito> Todos(){
        return distritoRepository.findAll();
    }
}
