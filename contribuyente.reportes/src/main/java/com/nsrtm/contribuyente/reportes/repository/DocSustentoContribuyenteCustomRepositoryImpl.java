package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.DocSustentoContribuyente;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

public class DocSustentoContribuyenteCustomRepositoryImpl implements DocSustentoContribuyenteCustomRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DocSustentoContribuyente> ListaDocSustento(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_DOC_SUSTENTO_LISTAR", DocSustentoContribuyente.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", numeroDJ);

        List<DocSustentoContribuyente> data = (List<DocSustentoContribuyente>) query.getResultList();
        return data;
    }

}
