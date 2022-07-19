package com.nsrtm.via.microservice.repository;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class ViaCustomRepositoryImpl implements ViaCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Ubicacion> ListaVia(Ubicacion custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_VIA.GET_VIA_LISTAR",Ubicacion.class)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_VIA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_VIA_ID", custom.tipo);

        List<Ubicacion> lista = (List<Ubicacion>)query.getResultList();
        return lista;
    }

    @Override
    public List<Ubicacion> ListaZonaUrbana(Ubicacion custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_VIA.GET_ZONA_URBANA_LISTAR",Ubicacion.class)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_ZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_ZONA_URBANA_ID", custom.tipo);

        List<Ubicacion> lista = (List<Ubicacion>)query.getResultList();
        return lista;
    }

    @Override
    public List<Ubicacion> ListaSubZonaUrbana(Ubicacion custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_VIA.GET_SUBZONA_URBANA_LISTAR",Ubicacion.class)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_SUBZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_SUBZONA_URBANA_ID", custom.tipo);

        List<Ubicacion> lista = (List<Ubicacion>)query.getResultList();
        return lista;
    }

    @Override
    public List<Ubicacion> ListaEdificacion(Ubicacion custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_VIA.GET_EDIFICACION_LISTAR",Ubicacion.class)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_EDIFICACION_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_EDIFICACION_ID", custom.tipo);

        List<Ubicacion> lista = (List<Ubicacion>)query.getResultList();
        return lista;
    }
}
