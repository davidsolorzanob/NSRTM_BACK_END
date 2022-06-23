package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;

@Entity
@Table(name="DOM_CONTRIBUYENTE_TIPO", schema = "NSRTM")
@IdClass(DomicilioContribuyenteTipoId.class)
public class DomicilioContribuyenteTipo extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "DOM_CONTRIBUYENTE_NUMERO")
    public Long domicilioContribuyenteNumero;

    @Id
    @Column(name = "TIP_DOMICILIO_ID")
    public Long tipoDomicilioId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;
}
