package com.nsrtm.contribuyente.microservice.resource;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.service.ContribuyenteService;


@RestController
@RequestMapping("/api/contribuyentes")
public class ContribuyenteResource {
	
	@Autowired
	private ContribuyenteService contribuyenteService;
	
	@GetMapping("todos")
	@ResponseStatus(HttpStatus.OK)
	public List<Contribuyente> todos() {
		
		
		List<Contribuyente> lista=new LinkedList<Contribuyente>();
		 
		Contribuyente a = new Contribuyente();
		a.CONTRIBUYENTE_ID="1";
		a.nombres="Luis";
		a.apellidoPaterno ="Espiritu";
		a.apellidoMaterno ="Castillejo";
		lista.add(a);
		return lista;
		
		
	}
}
