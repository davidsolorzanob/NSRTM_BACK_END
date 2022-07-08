package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.*;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsrtm.contribuyente.microservice.repository.ContribuyenteRepository;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	public ResponseEntity<Object> Crear(ContribuyenteCustom e){
		return contribuyenteRepository.CrearContribuyente(e);
	}

	public ResponseEntity<Object> Actualizar(ContribuyenteCustom e){
		return contribuyenteRepository.ActualizarContribuyente(e);
	}

	public ResponseEntity<Object> Eliminar(Long municipalidadId, Long contribuyenteNumero){
		ContribuyenteId id = new ContribuyenteId(municipalidadId,contribuyenteNumero);
		contribuyenteRepository.deleteById(id);
		return MessageResponse.setResponse(true, "El registro del contribuyente se eliminó satisfactoriamente");
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

	public PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom){
		return contribuyenteRepository.ListaContribuyentePaginado(custom);
	}

	public List<Contribuyente> Todos(){
		return contribuyenteRepository.findAll();
	}
}
