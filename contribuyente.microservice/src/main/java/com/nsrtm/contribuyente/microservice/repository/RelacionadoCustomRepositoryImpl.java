package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.Relacionado;
import com.nsrtm.contribuyente.microservice.domain.TipoRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.springframework.http.ResponseEntity;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

public class RelacionadoCustomRepositoryImpl implements RelacionadoCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Relacionado CrearRelacionado(Relacionado custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_RELACIONADO")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_REL_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_PERSONA_ID", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_TIP_RELACIONADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_INICIAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_FINAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOC_IDENTIDAD_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_DOC_IDENTIDAD", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_PATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_MATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOMBRES", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOM_APE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_RAZ_SOCIAL", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOMBRE_COMPLETO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_NACIMIENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_GENERO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FALLECIO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_FALLECIMIENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_EST_CIVIL_TIP_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_CREACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_CREACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", custom.contribuyenteNumero)
                .setParameter("P_TIP_RELACIONADO_ID", custom.tipoRelacionadoId)
                .setParameter("P_FEC_VIG_INICIAL", custom.fechaVigenciaInicialRela)
                .setParameter("P_FEC_VIG_FINAL", custom.fechaVigenciaFinalRela)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_DOC_IDENTIDAD_ID", custom.docIdentidadId)
                .setParameter("P_NUM_DOC_IDENTIDAD", custom.numDocIdentidad)
                .setParameter("P_APE_PATERNO", custom.apellidoPaterno)
                .setParameter("P_APE_MATERNO", custom.apellidoMaterno)
                .setParameter("P_NOMBRES",custom.nombres)
                .setParameter("P_RAZ_SOCIAL", custom.razonSocial)
                .setParameter("P_NOMBRE_COMPLETO", custom.nombreCompleto)
                .setParameter("P_FEC_NACIMIENTO",custom.fechaNacimiento)
                .setParameter("P_GENERO", custom.genero)
                .setParameter("P_FALLECIO", custom.fallecido)
                .setParameter("P_FEC_FALLECIMIENTO", custom.fechaFallecimiento)
                .setParameter("P_EST_CIVIL_TIP_ID", custom.estadoCivil)
                .setParameter("P_USUARIO_CREACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_CREACION", custom.terminalCreacion);
        query.execute();
        custom.relContribuyenteNumero = (Long) query.getOutputParameterValue("P_REL_CONTRIBUYENTE_NUMERO");
        custom.personaId = (Long) query.getOutputParameterValue("P_PERSONA_ID");
        return custom;
        //return MessageResponse.setResponse(true,"El relacionado se registró satisfactoriamente",custom);
    }

    @Override
    public ResponseEntity<Object> ActualizarRelacionado(Relacionado custom) {
        boolean success = false;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.UPD_RELACIONADO")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_REL_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PERSONA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_RELACIONADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_INICIAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_VIG_FINAL", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOC_IDENTIDAD_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_DOC_IDENTIDAD", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_PATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_MATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOMBRES", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOM_APE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_RAZ_SOCIAL", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOMBRE_COMPLETO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_NACIMIENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_GENERO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FALLECIO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_FALLECIMIENTO", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_EST_CIVIL_TIP_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", custom.numeroDJ)
                .setParameter("P_REL_CONTRIBUYENTE_NUMERO", custom.relContribuyenteNumero)
                .setParameter("P_TIP_RELACIONADO_ID", custom.tipoRelacionadoId)
                .setParameter("P_FEC_VIG_INICIAL", custom.fechaVigenciaInicialRela)
                .setParameter("P_FEC_VIG_FINAL", custom.fechaVigenciaFinalRela)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_DOC_IDENTIDAD_ID", custom.docIdentidadId)
                .setParameter("P_NUM_DOC_IDENTIDAD", custom.numDocIdentidad)
                .setParameter("P_APE_PATERNO", custom.apellidoPaterno)
                .setParameter("P_APE_MATERNO", custom.apellidoMaterno)
                .setParameter("P_NOMBRES",custom.nombres)
                .setParameter("P_RAZ_SOCIAL", custom.razonSocial)
                .setParameter("P_NOMBRE_COMPLETO", custom.nombreCompleto)
                .setParameter("P_FEC_NACIMIENTO",custom.fechaNacimiento)
                .setParameter("P_GENERO", custom.genero)
                .setParameter("P_FALLECIO", custom.fallecido)
                .setParameter("P_FEC_FALLECIMIENTO", custom.fechaFallecimiento)
                .setParameter("P_EST_CIVIL_TIP_ID", custom.estadoCivil)
                .setParameter("P_USUARIO_MODIFICACION", custom.usuarioModificacion)
                .setParameter("P_TERMINAL_MODIFICACION", custom.terminalModificacion);
        query.execute();
        return MessageResponse.setResponse(true,"Los datos del relacionado se actualizaron satisfactoriamente",custom);
    }

    @Override
    public Relacionado ObtenerRelacionado(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_RELACIONADO",Relacionado.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", numeroDJ);

        Relacionado data = (Relacionado)query.getSingleResult();
        return data;
    }

    @Override
    public RelacionadoCustom ObtenerRelacionadoConDomicilio(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_RELACIONADO_CON_DOMICILIO",RelacionadoCustom.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_NUMERO_DJ", numeroDJ);

        RelacionadoCustom data = (RelacionadoCustom)query.getSingleResult();
        return data;
    }
    @Override
    public List<TipoRelacionado> ListaTipoRelacionado(Integer tipo) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_TIPO_RELACIONADO_LISTAR", TipoRelacionado.class)
                .registerStoredProcedureParameter("P_TIP_PERSONA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)
                .setParameter("P_TIP_PERSONA_ID", tipo);

        List<TipoRelacionado> lista = (List<TipoRelacionado>)query.getResultList();
        return lista;
    }

}
