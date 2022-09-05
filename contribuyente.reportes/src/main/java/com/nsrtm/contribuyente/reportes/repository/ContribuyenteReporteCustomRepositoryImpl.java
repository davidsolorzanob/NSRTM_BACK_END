package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.ContribuyenteRequest;
import com.nsrtm.contribuyente.reportes.domain.ContribuyenteResult;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class ContribuyenteReporteCustomRepositoryImpl implements ContribuyenteReporteCustomRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ContribuyenteResult ObtenerContribuyenteReporte(ContribuyenteRequest custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_CONTRIBUYENTE_REPORTE_DJ",ContribuyenteResult.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)
                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", custom.numeroDJ);

        ContribuyenteResult data = (ContribuyenteResult)query.getSingleResult();
        return data;
    }
}
