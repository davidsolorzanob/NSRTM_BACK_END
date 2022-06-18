package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOM_CONTRIBUYENTE_TIPO", schema = "NSRTM")
public class DomicilioContribuyenteTipo extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "DOM_CONTRIBUYENTE_NUMERO")
    public Long domicilioContribuyenteNumero;

    @Column(name = "TIP_DOMICILIO_ID")
    public Integer tipoDomicilioId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;
}
