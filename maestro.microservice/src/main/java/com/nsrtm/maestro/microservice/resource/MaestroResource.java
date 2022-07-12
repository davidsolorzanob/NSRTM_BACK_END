package com.nsrtm.maestro.microservice.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.nsrtm.maestro.microservice.domain.Maestro;
import com.nsrtm.maestro.microservice.service.MaestroService;

@RestController
@RequestMapping("/api/maestro")
public class MaestroResource {
	@Autowired
	private MaestroService maestroService;

	@GetMapping("filtrarportipo")
	@ResponseStatus(HttpStatus.OK)
	public List<Maestro> FiltrarPorTipo(Integer tipoMaestroId, Long municipalidadId) {
		return maestroService.ObtenerPorFiltro(tipoMaestroId,municipalidadId);
	}

}
