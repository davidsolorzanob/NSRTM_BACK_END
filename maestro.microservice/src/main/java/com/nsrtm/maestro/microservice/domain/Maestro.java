package com.nsrtm.maestro.microservice.domain;

import javax.persistence.*;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "GetMaestro",
				procedureName = "NSRTM.PKG_CONTRIBUYENTE.GET_MAESTRO",
				resultClasses = Maestro.class,

				parameters = {
						@StoredProcedureParameter(type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
				}
		)})
@Entity
public class Maestro
{
	@Id
	@Column(name = "ID_MAESTRO")
	public Integer maestroId;
	
	@Column(name = "DESCRIPCION")
	public String descripcion;

	@Column(name = "ABREVIATURA")
	public String abreviatura;

	@Column(name = "ID_MAESTRO_SECUNDARIO")
	public Integer maestroSecundarioId;

	@Column(name = "DESCRIPCION_SECUNDARIO")
	public String descripcionSecundario;

	public Integer getMaestroId() {
		return maestroId;
	}

	public void setMaestroId(Integer maestroId) {
		this.maestroId = maestroId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Integer getMaestroSecundarioId() {
		return maestroSecundarioId;
	}

	public void setMaestroSecundarioId(Integer maestroSecundarioId) {
		this.maestroSecundarioId = maestroSecundarioId;
	}

	public String getDescripcionSecundario() {
		return descripcionSecundario;
	}

	public void setDescripcionSecundario(String descripcionSecundario) {
		this.descripcionSecundario = descripcionSecundario;
	}

	public Maestro() {
	}
}