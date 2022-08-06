package com.nsrtm.contribuyente.microservice.domain.complex;

import com.nsrtm.contribuyente.microservice.domain.Auditoria;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import javax.persistence.*;
import java.util.Date;

@Entity
@IdClass(ContribuyenteId.class)
public class ContribuyenteResult extends Auditoria
{
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
    public String numeroDJ;

    @Column(name = "DOC_IDENTIDAD_ID")
    public Integer docIdentidadId;

    @Column(name = "TIP_PERSONA_ID")
    public Integer tipoPersonaId;

    @Column(name = "DES_TIP_PERSONA")
    public String desTipoPersona;

    @Column(name = "DES_MOTIVO_DJ")
    public String desMotivoDj;

    @Column(name = "DES_ESTADO_DJ")
    public String desEstadoDj;

    @Column(name = "DES_TIP_MED_DETERMINACION")
    public String desTipoMedioDeterminacion;

    @Column(name = "DES_MED_DETERMINA")
    public String desMedioDeterminacion;

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

    @Column(name = "DES_CONDICION")
    public String desCondicion;

    @Column(name = "DEPARTAMENTO")
    public String departamento;

    @Column(name = "PROVINCIA")
    public String provincia;

    @Column(name = "DISTRITO")
    public String distrito;
}
