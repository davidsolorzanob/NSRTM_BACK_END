package com.nsrtm.contribuyente.microservice.domain.complex;
import com.nsrtm.contribuyente.microservice.domain.Auditoria;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;

import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ContribuyenteId.class)
public class ContribuyenteCustom extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Column(name = "FEC_INSCRIPCION")
    public Date fechaInscripcion;

    @Column(name = "FECHA_DJ")
    public Date fechaDJ;

    @Column(name = "NUMERO_DJ")
    public Long numeroDJ;

    @Column(name = "TIP_PERSONA_ID")
    public Integer tipoPersonaId;

    @Column(name = "MOTIVO_DJ_ID")
    public Integer motivoDjId;

    @Column(name = "ESTADO_DJ_ID")
    public Integer estadoDjId;

    @Column(name = "DES_ESTADO_DJ")
    public Integer desEstadoDj;

    @Column(name = "MOD_OFICIO")
    public Integer modalidadOficio;

    @Column(name = "TIP_MED_DETERMINA_ID")
    public Integer tipoMedioDeterminacionId;

    @Column(name = "MED_DETERMINA_ID")
    public Integer medioDeterminacionId;

    @Column(name = "SEG_CONTRIBUYENTE_ID")
    public Integer segContribuyenteId;

    @Column(name = "FUENTE_INFO_ID")
    public Integer fuenteInformacionId;

    @Column(name = "PERSONA_ID")
    public Long personaId;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "DESC_DOC_IDENTIDAD")
    public String descDocIdentidadId;

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

    @Column(name = "TIPO_ID")
    public Integer tipoFiltro;

    @Column(name = "EST_CIVIL_TIP_ID")
    public Integer estadoCivil;
}
