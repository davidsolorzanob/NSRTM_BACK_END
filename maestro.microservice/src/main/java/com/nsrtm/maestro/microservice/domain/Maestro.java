package com.nsrtm.maestro.microservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name ="maestro", schema = "public")
public class Maestro extends Auditoria
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "maestro_id")
	public Integer maestroId;
	
	@Column(name = "nombre")
	public String nombre;

	@Column(name = "tipomaestro_id")
	public Integer tipoMaestroId;

	public Maestro() {
	}
	
	public Maestro(Integer id, String name, Integer tipoId) {
		this.maestroId = id;
		this.nombre=name;
		this.tipoMaestroId = tipoId;
	}
}