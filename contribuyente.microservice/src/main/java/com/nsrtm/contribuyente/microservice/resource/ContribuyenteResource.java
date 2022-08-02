package com.nsrtm.contribuyente.microservice.resource;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.resource.model.ContribuyenteModel;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/contribuyente")
public class ContribuyenteResource {
	@Autowired
	private ContribuyenteService contribuyenteService;

	@PostMapping("guardar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Guardar (@RequestBody ContribuyenteModel model) {
		if(model.contribuyente.contribuyenteNumero == null)
			return contribuyenteService.Crear(model.contribuyente,
					                          model.condicionContribuyente,
											  model.domicilioContribuyente,
					 						  model.relacionado,
					                          model.contactos,
											  model.domicilios);
		else
			return contribuyenteService.Actualizar(model.contribuyente,
					model.condicionContribuyente,
					model.domicilioContribuyente,
					model.relacionado,
					model.contactos,
					model.domicilios);
	}

	@PostMapping("eliminar")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero) {
		return contribuyenteService.Eliminar(municipalidadId, contribuyenteNumero);
	}

	@GetMapping("obtener")
	@ResponseStatus(HttpStatus.OK)
	public ContribuyenteCustom ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
		return contribuyenteService.ObtenerPorId(municipalidadId, contribuyenteNumero);
	}

	@GetMapping("exportarExcel")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<StreamingResponseBody> ExportarExcel(String data, HttpServletResponse response) {
		ContribuyenteCustom custom = new Gson().fromJson(data, ContribuyenteCustom.class);
		return ResponseEntity.ok(contribuyenteService.ExportarExcel(custom, response));
	}

	@PostMapping("listaContribuyentePaginado")
	@ResponseStatus(HttpStatus.OK)
	public PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(@RequestBody PageRequest<ContribuyenteCustom> custom){
		return contribuyenteService.ListaContribuyentePaginado(custom);
	}
}
