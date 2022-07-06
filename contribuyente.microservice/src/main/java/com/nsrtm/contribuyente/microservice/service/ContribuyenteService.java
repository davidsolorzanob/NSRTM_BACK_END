package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.Persona;
import com.nsrtm.contribuyente.microservice.repository.PersonaRepository;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.repository.ContribuyenteRepository;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	@Autowired
	private PersonaRepository personaRepository;

	/*
	public void Guardar(Contribuyente e) {
		try{
			contribuyenteRepository.save(e);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}
*/

	public ResponseEntity<Object> Crear(ContribuyenteCustom e){
		return contribuyenteRepository.CrearContribuyente(e);
	}

	public ResponseEntity<Object> Actualizar(ContribuyenteCustom e){
		return contribuyenteRepository.CrearContribuyente(e);
	}

	public Contribuyente ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
		try {
			ContribuyenteId id = new ContribuyenteId(municipalidadId,contribuyenteNumero);
			return contribuyenteRepository.findById(id).get();
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public List<Contribuyente> Todos(){
		return contribuyenteRepository.findAll();
	}

	public PageResponse<List<ContribuyenteCustom>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom){
		return contribuyenteRepository.ListaContribuyentePaginado(custom);
	}
}
