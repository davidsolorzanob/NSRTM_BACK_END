package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;

@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteResource {
	@Autowired
	private ContribuyenteService contribuyenteService;

	@PostMapping("guardar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Guardar (@RequestBody ContribuyenteCustom contribuyente) {
		if(contribuyente.contribuyenteNumero <=0)
			return contribuyenteService.Crear(contribuyente);
		else
			return contribuyenteService.Actualizar(contribuyente);
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

	@PostMapping("listaContribuyentePaginado")
	@ResponseStatus(HttpStatus.OK)
	public PageResponse<List<ContribuyenteCustom>> ListaContribuyentePaginado(@RequestBody PageRequest<ContribuyenteCustom> custom){
		return contribuyenteService.ListaContribuyentePaginado(custom);
	}
}
