package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;

@Entity
@Table (name="contribuyente", schema = "public")
public class Contribuyente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contribuyente_id")
	public Long contribuyenteId;

	@Column(name = "sec_ejec")
	public String secEjec;

	@Column(name = "tipo_contribuyente_id")
	public Integer tipoContribuyenteId;

	@Column(name = "numero_documento")
	public String numeroDocumento;

	@Column(name = "apellido_paterno")
	public String apellidoPaterno;

	@Column(name = "apellido_materno")
	public String apellidoMaterno;

	@Column(name = "nombres")
	public String nombres;

	@Column(name = "razon_social")
	public String razonSocial;

	@Column(name = "celular_1")
	public String celular1;

	@Column(name = "celular_2")
	public String celular2;

	@Column(name = "correo_electronico_1")
	public String correoElectronico1;

	@Column(name = "correo_electronico_2")
	public String correoElectronico2;
}
