package com.nsrtm.contribuyente.reportes.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity
@IdClass(RelacionadoId.class)
public class RelacionadoResult {
    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "REL_CONTRIBUYENTE_NUMERO")
    public Long relContribuyenteNumero;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "DES_TIPO_RELACIONADO")
    public String desTipoRelacionado;

    @Column(name = "TIP_PERSONA_ID")
    public Integer tipoPersonaId;

    @Column(name = "DES_DOMICILIO")
    public String desDomicilio;

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

    @Column(name = "DEPARTAMENTO")
    public String departamento;

    @Column(name = "PROVINCIA")
    public String provincia;

    @Column(name = "DISTRITO")
    public String distrito;
}