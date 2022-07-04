package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;
import java.util.Date;

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetContribuyentesPaginado",
                procedureName = "NSRTM.PKG_CONTRIBUYENTE.GET_CONTRIBUYENTE_LISTAR",
                resultClasses = ContribuyenteCustom.class,
                parameters = {
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TIPO_FILTRO"),
                        @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN, name = "P_MUNICIPALIDAD_ID"),
                        @StoredProcedureParameter(type = Long.class, mode = ParameterMode.IN, name = "P_CONTRIBUYENTE_NUMERO"),
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TIP_PERSONA_ID"),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_NUM_DOC_IDENTIDAD"),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_APE_PATERNO"),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_APE_MATERNO"),
                        @StoredProcedureParameter(type = String.class, mode = ParameterMode.IN, name = "P_NOMBRES"),
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_RAZ_SOCIAL"),
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_NRO_PAGINA"),
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN, name = "P_TAM_PAGINA"),
                        @StoredProcedureParameter(type = Integer.class, mode = ParameterMode.OUT, name = "P_TOTAL_FILAS"),
                        @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
                }
        )})
@Entity
public class ContribuyenteCustom extends Auditoria{

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

}
