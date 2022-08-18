package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(DocSustentoContribuyenteId.class)
public class DocSustentoContribuyente extends Auditoria {
    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "NUMERO_DJ")
    public Long numeroDJ;

    @Id
    @Column(name = "DOC_SUS_CONTRIBUYENTE_ID")
    public Long docSustentoId;

    @Column(name = "TIP_DOC_SUSTENTO_ID")
    public Integer tipoDocSustentoId;

    @Column(name = "DES_TIPO_DOC_SUSTENTO")
    public String desTipoDocSustento;

    @Column(name = "NRO_DOC_SUSTENTO")
    public String nroDocSustento;

    @Column(name = "FOR_PRESENTACION_ID")
    public Integer tipoFormaPresentacionId;

    @Column(name = "DES_TIPO_PRESENTACION")
    public String desTipoFormaPresentacion;

    @Column(name = "FOLIOS")
    public Integer folios;

    @Column(name = "ACTIVO")
    public Integer activo;
}
