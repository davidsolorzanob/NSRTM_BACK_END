package com.nsrtm.contribuyente.microservice.domain.complex;

import com.nsrtm.contribuyente.microservice.domain.Auditoria;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoId;
import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(RelacionadoId.class)
public class RelacionadoCustom extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "REL_CONTRIBUYENTE_NUMERO")
    public Long relContribuyenteNumero;

    @Column(name = "PERSONA_ID")
    public Long personaId;

    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "DES_TIPO_RELACIONADO")
    public String desTipoRelacionado;

    @Column(name = "FEC_VIG_INICIAL")
    public Date fechaVigenciaInicialRela;

    @Column(name = "FEC_VIG_FINAL")
    public Date fechaVigenciaFinalRela;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "DES_DOC_IDENTIDAD")
    public String desDocIdentidad;

    @Column(name = "NUM_DOC_IDENTIDAD")
    public String numDocIdentidad;

    @Column(name = "APE_PATERNO")
    public String apellidoPaterno;

    @Column(name = "APE_MATERNO")
    public String apellidoMaterno;

    @Column(name = "NOMBRES")
    public String nombres;

    @Column(name = "RAZ_SOCIAL")
    public String razonSocial;

    @Column(name = "NOMBRE_COMPLETO")
    public String nombreCompleto;

    @Column(name = "FEC_NACIMIENTO")
    public Date fechaNacimiento;

    @Column(name = "GENERO")
    public String genero;

    @Column(name = "FALLECIO")
    public Integer fallecido;

    @Column(name = "FEC_FALLECIMIENTO")
    public Date fechaFallecimiento;

    @Column(name = "EST_CIVIL_TIP_ID")
    public Integer estadoCivil;

    @Column(name = "DES_CIVIL_TIPO")
    public String desEstadoCivil;

    @Column(name = "DOM_RELACIONADO_NUMERO")
    public Long domicilioRelacionadoNumero;

    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;

    @Column(name = "DES_DEPARTAMENTO")
    public String desDepartamento;

    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;

    @Column(name = "DES_PROVINCIA")
    public String desProvincia;

    @Column(name = "DISTRITO_ID")
    public Integer distritoId;

    @Column(name = "DES_DISTRITO")
    public String desDistrito;

    @Column(name = "TIP_PREDIO_ID")
    public Integer tipoPredioId;

    @Column(name = "DES_TIPO_PREDIO")
    public String desTipoPredio;

    @Column(name = "VIA_DEPARTAMENTO_ID")
    public Integer viaDepartamentoId;

    @Column(name = "DES_DEPARTAMENTO_VIA")
    public String desViaDepartamento;

    @Column(name = "VIA_PROVINCIA_ID")
    public Integer viaProvinciaId;

    @Column(name = "DES_PROVINCIA_VIA")
    public String desViaProvincia;

    @Column(name = "VIA_DISTRITO_ID")
    public Integer viaDistritoId;

    @Column(name = "DES_DISTRITO_VIA")
    public String desViaDistrito;

    @Column(name = "TIP_VIA_ID")
    public Integer tipoViaId;

    @Column(name = "DES_TIPO_VIA")
    public String desTipoVia;

    @Column(name = "VIA_ID")
    public Long viaId;

    @Column(name = "DES_VIA")
    public String desVia;

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

    @Column(name = "DES_ZONA_URBANA")
    public String desZonaUrbana;

    @Column(name = "TIP_ZONA_URBANA_ID")
    public Integer tipoZonaUrbanaId;

    @Column(name = "DES_TIPO_ZONA_URBANA")
    public String desTipoZonaUrbana;

    @Column(name = "SUBZONA_URBANA_ID")
    public Long subZonaUrbanaId;

    @Column(name = "DES_SUBZONA_URBANA")
    public String desSubZonaUrbana;

    @Column(name = "TIP_SUBZONA_URBANA_ID")
    public Integer tipoSubZonaUrbanaId;

    @Column(name = "DES_TIPO_SUBZONA_URBANA")
    public String desTipoSubZonaUrbana;

    @Column(name = "EDIFICACION_ID")
    public Long edificacionId;

    @Column(name = "DES_EDIFICACION")
    public String desEdificacion;

    @Column(name = "TIP_EDIFICACION_ID")
    public Integer tipoEdificacionId;

    @Column(name = "DES_TIPO_EDIFICACION")
    public String desTipoEdificacion;

    @Column(name = "TIP_INTERIOR_ID")
    public Long tipoInteriorId;

    @Column(name = "DES_TIPO_INTERIOR")
    public String desTipoInterior;

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

    @Column(name = "DES_DOMICILIO")
    public String descripcionDomicilio;

    @Column(name = "ESTRUCTURADO")
    public Integer estructurado;

    @Column(name = "FUENTE_INFO_ID")
    public Integer fuenteInformacionId;

    @Column(name = "DES_FUENTE_INFO")
    public String desFuenteInformacion;

    @Column(name = "DOM_ESTADO_ID")
    public Integer domEstadoId;

}
