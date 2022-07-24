package com.nsrtm.contribuyente.microservice.domain.complex;

import com.nsrtm.contribuyente.microservice.domain.Auditoria;
import com.nsrtm.contribuyente.microservice.domain.CondicionContribuyenteId;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(CondicionContribuyenteId.class)
public class CondicionContribuyenteCustom extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "CON_CONTRIBUYENTE_ID")
    public Long conContribuyenteId;

    @Column(name = "TIP_CON_INAFECTACION_ID")
    public Integer tipoCondicionInafectacionId;

    @Column(name = "DES_INAFECTACION_TIPO")
    public String desTipoInafectacion;

    @Column(name = "TIP_CON_CONCURSAL_ID")
    public Integer tipoCondicionConcursalId;

    @Column(name = "DES_CONCURSAL_TIPO")
    public String desTipoConcursal;

    @Column(name = "TIP_DOCUMENTO_ID")
    public Integer tipoDocumentoId;

    @Column(name = "DES_DOCUMENTO_TIPO")
    public String desTipoDocumento;

    @Column(name = "NOM_DOCUMENTO")
    public String nombreDocumento;

    @Column(name = "DES_DOCUMENTO")
    public String desDocumento;

    @Column(name = "NUM_DOCUMENTO")
    public String numeroDocumento;

    @Column(name = "FEC_DOCUMENTO")
    public Date fechaDocumento;

    @Column(name = "FEC_VIG_INICIAL")
    public Date fechaVigenciaInicial;

    @Column(name = "FEC_VIG_FINAL")
    public Date fechaVigenciaFinal;

    @Column(name = "IMP_PENSION")
    public Double importePension;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    @Column(name = "NUM_LICENCIA")
    public String numeroLicencia;

    @Column(name = "NUM_EXPEDIENTE")
    public String numeroExpediente;

    @Column(name = "FEC_EXPEDIENTE")
    public Date fechaExpediente;
}
