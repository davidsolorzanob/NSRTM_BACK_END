package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

public class CondicionContribuyenteCustomRepositoryImpl implements CondicionContribuyenteCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public CondicionContribuyenteCustom CrearCondicionContribuyente(CondicionContribuyenteCustom custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_CONDICION_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CON_CONTRIBUYENTE_ID", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_TIP_CON_INAFECTACION_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_CON_CONCURSAL_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_DOCUMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_DOCUMENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_DOCUMENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_DOCUMENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_INICIAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_FINAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_IMP_PENSION", Double.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_LICENCIA", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_EXPEDIENTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_EXPEDIENTE", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_CREACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_CREACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_TIP_CON_INAFECTACION_ID", custom.tipoCondicionInafectacionId)
                .setParameter("P_TIP_CON_CONCURSAL_ID", custom.tipoCondicionConcursalId)
                .setParameter("P_TIP_DOCUMENTO_ID", custom.tipoDocumentoId)
                .setParameter("P_DES_DOCUMENTO", custom.desDocumento)
                .setParameter("P_NUM_DOCUMENTO", custom.numeroDocumento)
                .setParameter("P_FEC_DOCUMENTO", custom.fechaDocumento)
                .setParameter("P_FEC_VIG_INICIAL", custom.fechaVigenciaInicial)
                .setParameter("P_FEC_VIG_FINAL", custom.fechaVigenciaFinal)
                .setParameter("P_IMP_PENSION", custom.importePension)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_NUM_LICENCIA", custom.numeroLicencia)
                .setParameter("P_NUM_EXPEDIENTE", custom.numeroExpediente)
                .setParameter("P_FEC_EXPEDIENTE", custom.fechaExpediente)
                .setParameter("P_USUARIO_CREACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_CREACION", custom.terminalCreacion);
        query.execute();
        custom.conContribuyenteId = (Long) query.getOutputParameterValue("P_CON_CONTRIBUYENTE_ID");
        //return MessageResponse.setResponse(true,"La condición de  contribuyente se registró satisfactoriamente",custom);
        return custom;
    }

    @Override
    public CondicionContribuyenteCustom ActualizarCondicionContribuyente(CondicionContribuyenteCustom custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_CONDICION_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CON_CONTRIBUYENTE_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_CON_INAFECTACION_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_CON_CONCURSAL_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_DOCUMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_DOCUMENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_DOCUMENTO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_DOCUMENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_INICIAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_FINAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_IMP_PENSION", Double.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_LICENCIA", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_EXPEDIENTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_EXPEDIENTE", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_CON_CONTRIBUYENTE_ID", custom.conContribuyenteId)
                .setParameter("P_TIP_CON_INAFECTACION_ID", custom.tipoCondicionInafectacionId)
                .setParameter("P_TIP_CON_CONCURSAL_ID", custom.tipoCondicionConcursalId)
                .setParameter("P_TIP_DOCUMENTO_ID", custom.tipoDocumentoId)
                .setParameter("P_DES_DOCUMENTO", custom.desDocumento)
                .setParameter("P_NUM_DOCUMENTO", custom.numeroDocumento)
                .setParameter("P_FEC_DOCUMENTO", custom.fechaDocumento)
                .setParameter("P_FEC_VIG_INICIAL", custom.fechaVigenciaInicial)
                .setParameter("P_FEC_VIG_FINAL", custom.fechaVigenciaFinal)
                .setParameter("P_IMP_PENSION", custom.importePension)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_NUM_LICENCIA", custom.numeroLicencia)
                .setParameter("P_NUM_EXPEDIENTE", custom.numeroExpediente)
                .setParameter("P_FEC_EXPEDIENTE", custom.fechaExpediente)
                .setParameter("P_USUARIO_MODIFICACION", custom.usuarioModificacion)
                .setParameter("P_TERMINAL_MODIFICACION", custom.terminalModificacion);
        query.execute();
        return custom;
    }

    @Override
    public CondicionContribuyenteCustom ObtenerCondicionContribuyente(Long municipalidadId, Long contribuyenteNumero) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_CONDICION",CondicionContribuyenteCustom.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero);

        CondicionContribuyenteCustom data = (CondicionContribuyenteCustom)query.getSingleResult();
        return data;
    }

}