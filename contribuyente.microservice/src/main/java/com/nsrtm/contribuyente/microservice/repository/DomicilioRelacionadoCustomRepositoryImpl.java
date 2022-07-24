package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import org.springframework.http.ResponseEntity;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

public class DomicilioRelacionadoCustomRepositoryImpl implements DomicilioRelacionadoCustomRepository{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public RelacionadoCustom CrearDomicilioRelacionado(RelacionadoCustom custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_DOMICILIO_RELACIONADO")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_REL_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOM_RELACIONADO_NUMERO", Long.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_PREDIO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_1", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LETRA_1", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_2", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LETRA_2", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MANZANA", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LOTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SUB_LOTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SUBZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_EDIFICACION_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_INTERIOR_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_INTERIOR", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_INGRESO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PISO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_KILOMETRO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_DOMICILIO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTRUCTURADO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FUENTE_INFO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_CREACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_CREACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_REL_CONTRIBUYENTE_NUMERO", custom.relContribuyenteNumero)
                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_PREDIO_ID", custom.tipoPredioId)
                .setParameter("P_VIA_DEPARTAMENTO_ID", custom.viaDepartamentoId)
                .setParameter("P_VIA_PROVINCIA_ID", custom.viaProvinciaId)
                .setParameter("P_VIA_DISTRITO_ID", custom.viaDistritoId)
                .setParameter("P_VIA_ID", custom.viaId)
                .setParameter("P_NUMERO_1", custom.numero1)
                .setParameter("P_LETRA_1", custom.letra1)
                .setParameter("P_NUMERO_2", custom.numero2)
                .setParameter("P_LETRA_2", custom.letra2)
                .setParameter("P_MANZANA", custom.manzana)
                .setParameter("P_LOTE", custom.lote)
                .setParameter("P_SUB_LOTE", custom.subLote)
                .setParameter("P_ZONA_URBANA_ID", custom.zonaUrbanaId)
                .setParameter("P_SUBZONA_URBANA_ID", custom.subZonaUrbanaId)
                .setParameter("P_EDIFICACION_ID", custom.edificacionId)
                .setParameter("P_TIP_INTERIOR_ID", custom.tipoInteriorId)
                .setParameter("P_DES_INTERIOR", custom.descripcionInterior)
                .setParameter("P_INGRESO", custom.ingreso)
                .setParameter("P_PISO", custom.piso)
                .setParameter("P_KILOMETRO", custom.kilometro)
                .setParameter("P_DES_DOMICILIO", custom.descripcionDomicilio)
                .setParameter("P_ESTRUCTURADO", custom.estructurado)
                .setParameter("P_FUENTE_INFO_ID", custom.fuenteInformacionId)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_USUARIO_CREACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_CREACION", custom.terminalCreacion);

        query.execute();
        custom.domicilioRelacionadoNumero = (Long) query.getOutputParameterValue("P_DOM_RELACIONADO_NUMERO");
        return custom;
        //return MessageResponse.setResponse(true,"El domicilio del relacionado se registró satisfactoriamente",custom);
    }

    @Override
    public ResponseEntity<Object> ActualizarDomicilioRelacionado(RelacionadoCustom custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.UPD_DOMICILIO_RELACIONADO")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_REL_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DOM_RELACIONADO_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DEPARTAMENTO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PROVINCIA_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DISTRITO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_PREDIO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_DEPARTAMENTO_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_PROVINCIA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_DISTRITO_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_VIA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_1", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LETRA_1", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_NUMERO_2", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LETRA_2", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MANZANA", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_LOTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SUB_LOTE", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_SUBZONA_URBANA_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_EDIFICACION_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_INTERIOR_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_INTERIOR", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_INGRESO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PISO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_KILOMETRO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_DOMICILIO", String.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTRUCTURADO", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_FUENTE_INFO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_ESTADO_ID", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_REL_CONTRIBUYENTE_NUMERO", custom.relContribuyenteNumero)
                .setParameter("P_DOM_RELACIONADO_NUMERO", custom.domicilioRelacionadoNumero)
                .setParameter("P_DEPARTAMENTO_ID", custom.departamentoId)
                .setParameter("P_PROVINCIA_ID", custom.provinciaId)
                .setParameter("P_DISTRITO_ID", custom.distritoId)
                .setParameter("P_TIP_PREDIO_ID", custom.tipoPredioId)
                .setParameter("P_VIA_DEPARTAMENTO_ID", custom.viaDepartamentoId)
                .setParameter("P_VIA_PROVINCIA_ID", custom.viaProvinciaId)
                .setParameter("P_VIA_DISTRITO_ID", custom.viaDistritoId)
                .setParameter("P_VIA_ID", custom.viaId)
                .setParameter("P_NUMERO_1", custom.numero1)
                .setParameter("P_LETRA_1", custom.letra1)
                .setParameter("P_NUMERO_2", custom.numero2)
                .setParameter("P_LETRA_2", custom.letra2)
                .setParameter("P_MANZANA", custom.manzana)
                .setParameter("P_LOTE", custom.lote)
                .setParameter("P_SUB_LOTE", custom.subLote)
                .setParameter("P_ZONA_URBANA_ID", custom.zonaUrbanaId)
                .setParameter("P_SUBZONA_URBANA_ID", custom.subZonaUrbanaId)
                .setParameter("P_EDIFICACION_ID", custom.edificacionId)
                .setParameter("P_TIP_INTERIOR_ID", custom.tipoInteriorId)
                .setParameter("P_DES_INTERIOR", custom.descripcionInterior)
                .setParameter("P_INGRESO", custom.ingreso)
                .setParameter("P_PISO", custom.piso)
                .setParameter("P_KILOMETRO", custom.kilometro)
                .setParameter("P_DES_DOMICILIO", custom.descripcionDomicilio)
                .setParameter("P_ESTRUCTURADO", custom.estructurado)
                .setParameter("P_FUENTE_INFO_ID", custom.fuenteInformacionId)
                .setParameter("P_ESTADO_ID", custom.estadoId)
                .setParameter("P_USUARIO_MODIFICACION", custom.usuarioModificacion)
                .setParameter("P_TERMINAL_MODIFICACION", custom.terminalModificacion);

        query.execute();
        return MessageResponse.setResponse(true,"El domicilio del relacionado se actualizó satisfactoriamente",custom);
    }

    @Override
    public DomicilioRelacionado ObtenerDomicilioRelacionado(Long municipalidadId, Long contribuyenteNumero, Long relcontribuyenteNumero) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_DOMICILIO_RELACIONADO",DomicilioRelacionado.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_REL_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_REL_CONTRIBUYENTE_NUMERO", relcontribuyenteNumero);

        DomicilioRelacionado data = (DomicilioRelacionado)query.getSingleResult();
        return data;
    }
}
