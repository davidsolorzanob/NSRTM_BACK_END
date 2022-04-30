package com.nsrtm.maestro.microservice.resource;

import java.util.List;

import com.nsrtm.maestro.microservice.util.ResponseService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.nsrtm.maestro.microservice.domain.TipoMaestro;
import com.nsrtm.maestro.microservice.service.TipoMaestroService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/tipomaestro")
public class TipoMaestroResource {
	@Autowired
	private TipoMaestroService tipoMaestroService;

	@PostMapping("crear")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Object> Crear(@Valid @RequestBody TipoMaestro tipo, BindingResult result) {
		if(result.hasErrors())
			return ResponseService.setResponse(HttpStatus.MULTI_STATUS, "Los campos del registro no son válidos");
		return tipoMaestroService.Guardar(tipo);
	}

	@PostMapping("editar")
	@ResponseStatus(HttpStatus.OK)
	public void Editar(@RequestBody TipoMaestro tipo) {
		tipoMaestroService.Actualizar(tipo);
	}

	@PostMapping("eliminar")
	@ResponseStatus(HttpStatus.OK)
	public void Eliminar(Integer id) {
		tipoMaestroService.Eliminar(id);
	}

	@GetMapping("obtener")
	@ResponseStatus(HttpStatus.OK)
	public TipoMaestro ObtenerPorId(Integer id) {
		return tipoMaestroService.ObtenerPorId(id);
	}

	@GetMapping("todos")
	@ResponseStatus(HttpStatus.OK)
	public List<TipoMaestro> Todos() {
		return tipoMaestroService.Todos();
	}

	@GetMapping("todostest")
	@CircuitBreaker(name = "tipoMaestroService", fallbackMethod = "TodosTestError")
	public ResponseEntity<TipoMaestro> TodosTest(Integer id) {
		return new ResponseEntity<TipoMaestro>(tipoMaestroService.TodosTest(id),HttpStatus.OK);
	}

	public ResponseEntity<String> TodosTestError(Exception e) {
		return new ResponseEntity<String>("subscribe service is down", HttpStatus.OK);
	}

/*
	@Override
	public ResponseEntity error(HttpServletRequest request) {
		HttpStatus status = getStatus(request);
		if (status.equals(HttpStatus.INTERNAL_SERVER_ERROR)){
			return ResponseEntity.status(status).body(HttpStatus.INTERNAL_SERVER_ERROR);
		}else if (status.equals(HttpStatus.BAD_REQUEST)){
			return ResponseEntity.status(status).body(HttpStatus.BAD_REQUEST);
		}
		return super.error(request);
	}

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	*/

}
