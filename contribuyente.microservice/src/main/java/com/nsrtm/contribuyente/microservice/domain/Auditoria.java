package com.nsrtm.contribuyente.microservice.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Auditoria {
	public String USUARIO_REGISTRO;
	public String FECHA_REGISTRO;
	public String USUARIO_EDICION;
	public String FECHA_EDICION;
}
