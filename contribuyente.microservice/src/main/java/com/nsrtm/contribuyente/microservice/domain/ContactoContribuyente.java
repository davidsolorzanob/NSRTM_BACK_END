package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;

@Entity
//@Table(name="MED_CON_CONTRIBUYENTE", schema = "NSRTM")
@IdClass(ContactoContribuyenteId.class)
public class ContactoContribuyente extends Auditoria {
    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "MED_CON_CONTRIBUYENTE_ID")
    public Long contactoContribuyenteId;

    @Column(name = "TIP_MED_CONTACTO_ID")
    public Integer tipoMedioContactoId;

    @Column(name = "DES_TIP_MED_CONTACTO")
    public String desTipoMedioContacto;

    @Column(name = "CLA_MED_CONTACTO_ID")
    public Integer claseMedioContactoId;

    @Column(name = "DES_CLA_MED_CONTACTO")
    public String desClaseMedioContacto;

    @Column(name = "DES_MED_CON_CONTRIBUYENTE")
    public String desMedioContacto;

    @Column(name = "PRINCIPAL")
    public Integer principal;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

}
