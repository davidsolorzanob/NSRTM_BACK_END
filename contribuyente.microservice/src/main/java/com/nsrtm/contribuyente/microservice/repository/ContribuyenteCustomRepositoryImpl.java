package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Component
public class ContribuyenteCustomRepositoryImpl implements ContribuyenteCustomRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ResponseEntity<Object> CrearContribuyente(ContribuyenteCustom custom) {
        boolean success = false;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_FEC_INSCRIPCION", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FECHA_DJ", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_PERSONA_ID", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_TIP_PERSONA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MOTIVO_DJ_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_DJ_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MOD_OFICIO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_MED_DETERMINA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MED_DETERMINA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SEG_CONTRIBUYENTE_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FUENTE_INFO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN)
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
                .setParameter("P_FEC_INSCRIPCION", custom.fechaInscripcion)
                .setParameter("P_FECHA_DJ", custom.fechaDJ)
                .setParameter("P_TIP_PERSONA_ID", custom.tipoPersonaId)
                .setParameter("P_MOTIVO_DJ_ID", custom.motivoDjId)
                .setParameter("P_ESTADO_DJ_ID", custom.estadoDjId)
                .setParameter("P_MOD_OFICIO", custom.modalidadOficio)
                .setParameter("P_TIP_MED_DETERMINA_ID", custom.tipoMedioDeterminacionId)
                .setParameter("P_MED_DETERMINA_ID", custom.medioDeterminacionId)
                .setParameter("P_SEG_CONTRIBUYENTE_ID", custom.segContribuyenteId)
                .setParameter("P_FUENTE_INFO_ID", custom.fuenteInformacionId)
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
        custom.contribuyenteNumero = (Long) query.getOutputParameterValue("P_CONTRIBUYENTE_NUMERO");
        custom.numeroDJ = (Long) query.getOutputParameterValue("P_NUMERO_DJ");
        custom.personaId = (Long) query.getOutputParameterValue("P_PERSONA_ID");
        return MessageResponse.setResponse(true,"El contribuyente se registró satisfactoriamente",custom);
    }

    @Override
    public ResponseEntity<Object> ActualizarContribuyente(ContribuyenteCustom custom) {
        boolean success = false;
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.UPD_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FEC_INSCRIPCION", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FECHA_DJ", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_DJ", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PERSONA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_PERSONA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MOTIVO_DJ_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_DJ_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MOD_OFICIO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_MED_DETERMINA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MED_DETERMINA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SEG_CONTRIBUYENTE_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FUENTE_INFO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CLAVE", String.class, ParameterMode.IN)
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
                .setParameter("P_FEC_INSCRIPCION", custom.fechaInscripcion)
                .setParameter("P_FECHA_DJ", custom.fechaDJ)
                .setParameter("P_NUMERO_DJ", custom.numeroDJ)
                .setParameter("P_TIP_PERSONA_ID", custom.tipoPersonaId)
                .setParameter("P_PERSONA_ID", custom.personaId)
                .setParameter("P_MOTIVO_DJ_ID", custom.motivoDjId)
                .setParameter("P_ESTADO_DJ_ID", custom.estadoDjId)
                .setParameter("P_MOD_OFICIO", custom.modalidadOficio)
                .setParameter("P_TIP_MED_DETERMINA_ID", custom.tipoMedioDeterminacionId)
                .setParameter("P_MED_DETERMINA_ID", custom.medioDeterminacionId)
                .setParameter("P_SEG_CONTRIBUYENTE_ID", custom.segContribuyenteId)
                .setParameter("P_FUENTE_INFO_ID", custom.fuenteInformacionId)
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
        return MessageResponse.setResponse(true,"Los datos del contribuyente se actualizaron satisfactoriamente",custom);
    }

    @Override
    public PageResponse<List<ContribuyenteCustom>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_CONTRIBUYENTE_LISTAR")
                .registerStoredProcedureParameter("P_TIPO_FILTRO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_PERSONA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUM_DOC_IDENTIDAD", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_PATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_APE_MATERNO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NOMBRES", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_RAZ_SOCIAL", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NRO_PAGINA", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TAM_PAGINA", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TOTAL_FILAS", Integer.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)
                .setParameter("P_TIPO_FILTRO", custom.data.tipoFiltro)
                .setParameter("P_MUNICIPALIDAD_ID", custom.data.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.data.contribuyenteNumero)
                .setParameter("P_TIP_PERSONA_ID", custom.data.tipoPersonaId)
                .setParameter("P_NUM_DOC_IDENTIDAD", custom.data.numDocIdentidad)
                .setParameter("P_APE_PATERNO", custom.data.apellidoPaterno)
                .setParameter("P_APE_MATERNO", custom.data.apellidoMaterno)
                .setParameter("P_NOMBRES", custom.data.nombres)
                .setParameter("P_RAZ_SOCIAL",custom.data.razonSocial)
                .setParameter("P_NRO_PAGINA", custom.nroPage)
                .setParameter("P_TAM_PAGINA", custom.size);

        PageResponse<List<ContribuyenteCustom>> page = new PageResponse<List<ContribuyenteCustom>>(custom.size,custom.nroPage);
        page.data = query.getResultList();
        page.totalRows = (Integer) query.getOutputParameterValue("P_TOTAL_FILAS");
        return page;
    }

}