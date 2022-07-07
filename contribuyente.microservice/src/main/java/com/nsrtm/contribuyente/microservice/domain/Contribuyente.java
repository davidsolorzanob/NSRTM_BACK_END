package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name="CONTRIBUYENTE", schema = "NSRTM")
@IdClass(ContribuyenteId.class)
public class Contribuyente extends Auditoria {

	@Id
	@Column(name = "MUNICIPALIDAD_ID")
	public Long municipalidadId;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRIBUYENTE_NUMERO")
	public Long contribuyenteNumero;

	@Column(name = "FEC_INSCRIPCION")
	public Date fechaInscripcion;

	@Column(name = "FECHA_DJ")
	public Date fechaDJ;

	@Column(name = "NUMERO_DJ")
	public Long numeroDJ;

	@Column(name = "PERSONA_ID")
	public Long personaId;

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

	@Column(name = "CLAVE")
	public String clave;

	@Column(name = "EST_CIVIL_TIP_ID")
	public Integer estadoCivil;
}
