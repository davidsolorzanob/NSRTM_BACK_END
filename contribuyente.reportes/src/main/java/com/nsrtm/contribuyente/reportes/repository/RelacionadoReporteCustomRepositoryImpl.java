package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.domain.RelacionadoResult;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class RelacionadoReporteCustomRepositoryImpl implements RelacionadoReporteCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RelacionadoResult ObtenerRelacionadoReporte(ContribuyenteRequest custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_RELACIONADO_REPORTE_DJ",RelacionadoResult.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)
                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero);

        RelacionadoResult data = (RelacionadoResult)query.getSingleResult();
        return data;
    }
}
