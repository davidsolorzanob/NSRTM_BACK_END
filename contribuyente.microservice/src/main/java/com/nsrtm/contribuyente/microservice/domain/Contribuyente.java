package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;

@Entity
@Table (name="contribuyente", schema = "public")
public class Contribuyente extends Persona {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contribuyente_id")
	public Long contribuyenteId;

	@Column(name = "sec_ejec")
	public String secEjec;

	@Column(name = "tipo_contribuyente_id")
	public Integer tipoContribuyenteId;


}
