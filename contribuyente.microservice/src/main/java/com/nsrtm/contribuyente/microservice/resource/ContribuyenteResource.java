package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.resource.model.ContribuyenteModel;
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
	public ResponseEntity<Object> Guardar (@RequestBody ContribuyenteModel model) {
		//if(model.contribuyenteCustom.contribuyenteNumero == null)
			return contribuyenteService.Crear(model.contribuyenteCustom,
					                          model.condicionContribuyenteCustom,
											  model.domicilioContribuyente,
					 						  model.relacionadoCustom);
		//else
			//return contribuyenteService.Actualizar(model.contribuyenteCustom);
	}

	@PostMapping("eliminar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero) {
		return contribuyenteService.Eliminar(municipalidadId, contribuyenteNumero);
	}

	@GetMapping("obtener")
	@ResponseStatus(HttpStatus.OK)
	public Contribuyente ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
		return contribuyenteService.ObtenerPorId(municipalidadId, contribuyenteNumero);
	}

	@PostMapping("listaContribuyentePaginado")
	@ResponseStatus(HttpStatus.OK)
	public PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(@RequestBody PageRequest<ContribuyenteCustom> custom){
		return contribuyenteService.ListaContribuyentePaginado(custom);
	}
}
