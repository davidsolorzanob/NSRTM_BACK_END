package com.nsrtm.maestro.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name ="tipo_maestro", schema = "public")
public class TipoMaestro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipomaestro_id")
	public Integer tipoMaestroId;

	@NotEmpty(message="Campo obligatorio")
	@Column(name = "nombre")
	public String nombre;
		
	public TipoMaestro() {

	}
	
	public TipoMaestro(Integer id, String name) {
		this.tipoMaestroId = id;
		this.nombre=name;
	}
}
