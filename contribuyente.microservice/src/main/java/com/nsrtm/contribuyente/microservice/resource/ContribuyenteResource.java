package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;

@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteResource {
	@Autowired
	private ContribuyenteService contribuyenteService;

	@PostMapping("crear")
	@ResponseStatus(HttpStatus.OK)
	public void Crear(@RequestBody Contribuyente contribuyente) {
		contribuyenteService.Guardar(contribuyente);
	}

	@PostMapping("editar")
	@ResponseStatus(HttpStatus.OK)
	public void Editar(@RequestBody Contribuyente contribuyente) {
		contribuyenteService.Actualizar(contribuyente);
	}

	@PostMapping("eliminar")
	@ResponseStatus(HttpStatus.OK)
	public void Eliminar(Long id) {
		contribuyenteService.Eliminar(id);
	}

	@GetMapping("obtener")
	@ResponseStatus(HttpStatus.OK)
	public Contribuyente ObtenerPorId(Long id) {
		return contribuyenteService.ObtenerPorId(id);
	}

	@GetMapping("todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Contribuyente> Todos() {
		return contribuyenteService.Todos();
	}

	@PostMapping("filtrar")
	@ResponseStatus(HttpStatus.OK)
	public List<Contribuyente> Filtrar(@RequestBody Contribuyente contribuyente) {
		return contribuyenteService.ListarPorFiltros(contribuyente);
	}
}
