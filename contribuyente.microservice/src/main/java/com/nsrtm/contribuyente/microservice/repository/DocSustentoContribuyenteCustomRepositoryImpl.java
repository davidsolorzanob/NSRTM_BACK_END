package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyente;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

public class DocSustentoContribuyenteCustomRepositoryImpl implements DocSustentoContribuyenteCustomRepository  {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public DocSustentoContribuyente CrearDocSustento(DocSustentoContribuyente custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_DOC_SUSTENTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOC_SUS_CONTRIBUYENTE_ID", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_TIP_DOC_SUSTENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NRO_DOC_SUSTENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FOR_PRESENTACION_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FOLIOS", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_CREACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_CREACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", custom.numeroDJ)
                .setParameter("P_TIP_DOC_SUSTENTO_ID", custom.tipoDocSustentoId)
                .setParameter("P_NRO_DOC_SUSTENTO", custom.nroDocSustento)
                .setParameter("P_FOR_PRESENTACION_ID", custom.tipoFormaPresentacionId)
                .setParameter("P_FOLIOS", custom.folios)
                .setParameter("P_USUARIO_CREACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_CREACION", custom.terminalCreacion);
        query.execute();
        DocSustentoContribuyente data = custom;
        data.docSustentoId = (Long) query.getOutputParameterValue("P_DOC_SUS_CONTRIBUYENTE_ID");
        return data;
    }

    @Override
    public List<DocSustentoContribuyente> CrearContactoLista(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ, List<DocSustentoContribuyente> lista) {
        List<DocSustentoContribuyente> saveLista = new ArrayList<DocSustentoContribuyente>();
        for (DocSustentoContribuyente item:lista) {
            item.municipalidadId = municipalidadId;
            item.contribuyenteNumero = contribuyenteNumero;
            item.numeroDJ = numeroDJ;
            item = CrearDocSustento(item);
            saveLista.add(item);
        }
        return saveLista;
    }

    @Override
    public DocSustentoContribuyente ActualizarDocSustento(DocSustentoContribuyente custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.UPD_DOC_SUSTENTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOC_SUS_CONTRIBUYENTE_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_DOC_SUSTENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NRO_DOC_SUSTENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FOR_PRESENTACION_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FOLIOS", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_DOC_SUS_CONTRIBUYENTE_ID", custom.docSustentoId)
                .setParameter("P_TIP_DOC_SUSTENTO_ID", custom.tipoDocSustentoId)
                .setParameter("P_NRO_DOC_SUSTENTO", custom.nroDocSustento)
                .setParameter("P_FOR_PRESENTACION_ID", custom.tipoFormaPresentacionId)
                .setParameter("P_FOLIOS", custom.folios)
                .setParameter("P_USUARIO_MODIFICACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_MODIFICACION", custom.terminalCreacion);
        query.execute();
        return custom;
    }

    @Override
    public boolean EliminarDocSustento(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ, Long docSustentoId, Long usuarioRegistro, String terminalRegistro) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.DEL_DOC_SUSTENTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOC_SUS_CONTRIBUYENTE_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", numeroDJ)
                .setParameter("P_DOC_SUS_CONTRIBUYENTE_ID", docSustentoId)
                .setParameter("P_USUARIO_MODIFICACION", usuarioRegistro)
                .setParameter("P_TERMINAL_MODIFICACION", terminalRegistro);

        query.execute();
        return true;
    }

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
