package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Date;
import java.util.List;

public class ContactoContribuyenteCustomRepositoryImpl implements ContactoContribuyenteCustomRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public ContactoContribuyente CrearContacto(ContactoContribuyente custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.INS_CONTACTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MED_CON_CONTRIBUYENTE_ID", Date.class, ParameterMode.OUT)
                .registerStoredProcedureParameter("P_TIP_MED_CONTACTO_ID", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CLA_MED_CONTACTO_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_MED_CON_CONTRIBUYENTE", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PRINCIPAL", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_CREACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_CREACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_TIP_MED_CONTACTO_ID", custom.tipoMedioContactoId)
                .setParameter("P_CLA_MED_CONTACTO_ID", custom.claseMedioContactoId)
                .setParameter("P_DES_MED_CON_CONTRIBUYENTE", custom.desMedioContacto)
                .setParameter("P_PRINCIPAL", custom.principal)
                .setParameter("P_USUARIO_CREACION", custom.usuarioCreacion)
                .setParameter("P_TERMINAL_CREACION", custom.terminalCreacion);
        query.execute();
        ContactoContribuyente data = custom;
        data.contactoContribuyenteId = (Long) query.getOutputParameterValue("P_MED_CON_CONTRIBUYENTE_ID");
        return data;
    }

    @Override
    public List<ContactoContribuyente> CrearContactoLista(Long municipalidadId, Long contribuyenteNumero, List<ContactoContribuyente> lista) {
        List<ContactoContribuyente> saveLista = null;
        for (ContactoContribuyente item:lista) {
            item.municipalidadId = municipalidadId;
            item.contribuyenteNumero = contribuyenteNumero;
            item = CrearContacto(item);
            saveLista.add(item);
        }
        return saveLista;
    }

    @Override
    public ContactoContribuyente ActualizarContacto(ContactoContribuyente custom) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.UPD_CONTACTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MED_CON_CONTRIBUYENTE_ID", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TIP_MED_CONTACTO_ID", Date.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CLA_MED_CONTACTO_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_DES_MED_CON_CONTRIBUYENTE", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_PRINCIPAL", Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_USUARIO_MODIFICACION", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_TERMINAL_MODIFICACION", String.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", custom.municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", custom.contribuyenteNumero)
                .setParameter("P_MED_CON_CONTRIBUYENTE_ID", custom.contactoContribuyenteId)
                .setParameter("P_TIP_MED_CONTACTO_ID", custom.tipoMedioContactoId)
                .setParameter("P_CLA_MED_CONTACTO_ID", custom.claseMedioContactoId)
                .setParameter("P_DES_MED_CON_CONTRIBUYENTE", custom.desMedioContacto)
                .setParameter("P_PRINCIPAL", custom.principal)
                .setParameter("P_USUARIO_MODIFICACION", custom.usuarioModificacion)
                .setParameter("P_TERMINAL_MODIFICACION", custom.terminalModificacion);
        query.execute();
        return custom;
    }

    @Override
    public boolean EliminarContacto(Long municipalidadId, Long contribuyenteNumero, Long contactoContribuyenteId) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.DEL_CONTACTO_CONTRIBUYENTE")
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_MED_CON_CONTRIBUYENTE_ID", Long.class, ParameterMode.IN)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero)
                .setParameter("P_MED_CON_CONTRIBUYENTE_ID", contactoContribuyenteId);

        query.execute();
        return true;
    }

    @Override
    public List<ContactoContribuyente> ListaContacto(Long municipalidadId, Long contribuyenteNumero) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("NSRTM.PKG_CONTRIBUYENTE.GET_CONTACTO_LISTAR", ContribuyenteResult.class)
                .registerStoredProcedureParameter("P_MUNICIPALIDAD_ID", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("P_CONTRIBUYENTE_NUMERO", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("RESULT_CSR", void.class, ParameterMode.REF_CURSOR)

                .setParameter("P_MUNICIPALIDAD_ID", municipalidadId)
                .setParameter("P_CONTRIBUYENTE_NUMERO", contribuyenteNumero);

        List<ContactoContribuyente> data = (List<ContactoContribuyente>) query.getResultList();
        return data;
    }


}