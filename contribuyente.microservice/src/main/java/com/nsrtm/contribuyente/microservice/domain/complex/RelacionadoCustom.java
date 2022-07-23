package com.nsrtm.contribuyente.microservice.domain.complex;

import com.nsrtm.contribuyente.microservice.domain.Auditoria;
import com.nsrtm.contribuyente.microservice.domain.DomicilioRelacionado;
import com.nsrtm.contribuyente.microservice.domain.RelacionadoId;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@IdClass(RelacionadoId.class)
public class RelacionadoCustom extends DomicilioRelacionado {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "REL_CONTRIBUYENTE_NUMERO")
    public Long relContribuyenteNumero;

    @Column(name = "PERSONA_ID")
    public Long personaId;

    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "FEC_VIG_INICIAL")
    public Date fechaVigenciaInicialRela;

    @Column(name = "FEC_VIG_FINAL")
    public Date fechaVigenciaFinalRela;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    @Column(name = "DESC_DOC_IDENTIDAD")
    public Integer descDocIdentidadId;

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

}
