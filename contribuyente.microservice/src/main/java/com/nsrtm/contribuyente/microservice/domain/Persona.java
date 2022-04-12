package com.nsrtm.contribuyente.microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Persona extends Auditoria {
	public String personaId;
	public String numeroDocumento;
	public String apellidoPaterno;
	public String apellidoMaterno;
	public String nombres;
	public String razonSocial;
	public String celular1;
	public String celular2;
	public String correoElectronico1;
	public String correoElectronico2;
}
