package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOM_CONTRIBUYENTE", schema = "NSRTM")
public class DomicilioContribuyente extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "DOM_CONTRIBUYENTE_NUMERO")
    public Long domicilioContribuyenteNumero;

    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;

    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;

    @Column(name = "DISTRITO")
    public Integer distritoId;

    @Column(name = "TIP_PREDIO_ID")
    public Integer tipoPredioId;

    @Column(name = "VIA_DEPARTAMENTO_ID")
    public Integer viaDepartamentoId;

    @Column(name = "VIA_PROVINCIA_ID")
    public Integer viaProvinciaId;

    @Column(name = "VIA_DISTRITO")
    public Integer viaDistritoId;

    @Column(name = "VIA_ID")
    public Integer viaId;

    @Column(name = "NUMERO_1")
    public Integer numero1;

    @Column(name = "LETRA_1")
    public String letra1;

    @Column(name = "NUMERO_2")
    public Integer numero2;

    @Column(name = "LETRA_2")
    public String letra2;

    @Column(name = "MANZANA")
    public String manzana;

    @Column(name = "LOTE")
    public String lote;

    @Column(name = "SUB_LOTE")
    public String subLote;

    @Column(name = "ZONA_URBANA_ID")
    public Long zonaUrbanaId;

    @Column(name = "SUBZONA_URBANA_ID")
    public Long subZonaUrbanaId;

    @Column(name = "EDIFICACION_ID")
    public Long edificacionId;

    @Column(name = "TIP_INTERIOR_ID")
    public Long tipoInteriorId;

    @Column(name = "DES_INTERIOR")
    public String descripcionInterior;

    @Column(name = "INGRESO")
    public String ingreso;

    @Column(name = "PISO")
    public String piso;

    @Column(name = "KILOMETRO")
    public String kilometro;

    @Column(name = "REFERENCIA")
    public String referencia;

    @Column(name = "LATITUD")
    public double latitud;

    @Column(name = "LONGITUG")
    public double longitud;

    @Column(name = "DES_DOMICILIO")
    public String descripcionDomicilio;

    @Column(name = "ESTRUCTURADO")
    public Integer estructurado;

    @Column(name = "FUENTE_INFO_ID")
    public Integer fuenteInformacionId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;
}
