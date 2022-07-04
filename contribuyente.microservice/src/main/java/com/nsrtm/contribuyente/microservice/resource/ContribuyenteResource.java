package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;

@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteResource {
	@Autowired
	private ContribuyenteService contribuyenteService;

	@PostMapping("editar")
	@ResponseStatus(HttpStatus.OK)
	public void guardar (@RequestBody ContribuyenteCustom contribuyente) {

		if(contribuyente.contribuyenteNumero <=0)
			contribuyenteService.Crear(contribuyente);
		else
			contribuyenteService.Actualizar(contribuyente);
	}

	@PostMapping("eliminar")
	@ResponseStatus(HttpStatus.OK)
	public void Eliminar(Long municipalidadId, Long contribuyenteNumero) {
		contribuyenteService.Eliminar(municipalidadId, contribuyenteNumero);
	}

	@GetMapping("obtener")
	@ResponseStatus(HttpStatus.OK)
	public Contribuyente ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
		return contribuyenteService.ObtenerPorId(municipalidadId, contribuyenteNumero);
	}

	@GetMapping("todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Contribuyente> Todos() {
		return contribuyenteService.Todos();
	}
}
