package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;

import com.nsrtm.contribuyente.microservice.util.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.validation.Valid;

@EnableWebMvc
@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteResource {
	@Autowired
	private ContribuyenteService contribuyenteService;

	@PostMapping("crear")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Crear(@Valid @RequestBody Contribuyente contribuyente, BindingResult result) {
		if(result.hasErrors())
			return ResponseService.setResponse(HttpStatus.MULTI_STATUS, "Los campos del registro no son válidos");
		return contribuyenteService.Guardar(contribuyente);
	}

	@PutMapping("editar")
	@ResponseStatus(HttpStatus.OK)
	public void Editar(@RequestBody Contribuyente contribuyente) {
		contribuyenteService.Actualizar(contribuyente);
	}

	@DeleteMapping("eliminar")
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
