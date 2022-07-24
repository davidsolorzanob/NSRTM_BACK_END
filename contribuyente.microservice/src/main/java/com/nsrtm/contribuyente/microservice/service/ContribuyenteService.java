package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.*;
import com.nsrtm.contribuyente.microservice.domain.complex.CondicionContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.domain.complex.RelacionadoCustom;
import com.nsrtm.contribuyente.microservice.repository.*;
import com.nsrtm.contribuyente.microservice.util.MessageResponse;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	@Autowired
	private CondicionContribuyenteRepository condicionContribuyenteRepository;

	@Autowired
	private DomicilioContribuyenteRepository domicilioContribuyenteRepository;

	@Autowired
	private RelacionadoRepository relacionadoRepository;

	@Autowired
	private DomicilioRelacionadoRepository domicilioRelacionadoRepository;

	@Transactional
	public ResponseEntity<Object> Crear(ContribuyenteCustom contribuyente,
										CondicionContribuyenteCustom condicion,
										DomicilioContribuyente domContribuyente,
										RelacionadoCustom relacionado){

		contribuyente = contribuyenteRepository.CrearContribuyente(contribuyente);

		condicion.contribuyenteNumero = contribuyente.contribuyenteNumero;
		condicionContribuyenteRepository.CrearCondicionContribuyente(condicion);

		domContribuyente.contribuyenteNumero = contribuyente.contribuyenteNumero;
		domicilioContribuyenteRepository.CrearDomicilioContribuyente(domContribuyente);

		relacionado.contribuyenteNumero = contribuyente.contribuyenteNumero;
		relacionado = relacionadoRepository.CrearRelacionado(relacionado);

		domicilioRelacionadoRepository.CrearDomicilioRelacionado(relacionado);
		return MessageResponse.setResponse(true, "El registro del contribuyente se guardó satisfactoriamente", contribuyente);
	}

	public ResponseEntity<Object> Actualizar(ContribuyenteCustom contribuyente,
											 CondicionContribuyenteCustom condicion,
											 DomicilioContribuyente domContribuyente,
											 RelacionadoCustom relacionado){
		contribuyenteRepository.ActualizarContribuyente(contribuyente);
		condicionContribuyenteRepository.ActualizarCondicionContribuyente(condicion);
		domicilioContribuyenteRepository.ActualizarDomicilioContribuyente(domContribuyente);
		relacionadoRepository.ActualizarRelacionado(relacionado);
		domicilioRelacionadoRepository.ActualizarDomicilioRelacionado(relacionado);
		return MessageResponse.setResponse(true, "El registro del contribuyente se actualizó satisfactoriamente", contribuyente);
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
