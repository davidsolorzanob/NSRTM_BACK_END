package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.Domicilio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.repository.ContribuyenteRepository;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	public void Guardar(Contribuyente e) {
		try{
			contribuyenteRepository.save(e);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Actualizar(Contribuyente e){
		try {
			Contribuyente contribuyente = ObtenerPorId(e.contribuyenteId);
			contribuyente.contribuyenteId = e.contribuyenteId;
			contribuyente.secEjec = e.secEjec;
			contribuyente.tipoContribuyenteId = e.tipoContribuyenteId;
			contribuyente.numeroDocumento = e.numeroDocumento;
			contribuyente.apellidoPaterno = e.apellidoPaterno;
			contribuyente.apellidoMaterno = e.apellidoMaterno;
			contribuyente.nombres = e.nombres;
			contribuyente.razonSocial = e.razonSocial;
			contribuyente.celular1 = e.celular1;
			contribuyente.celular2 = e.celular2;
			contribuyente.correoElectronico1 = e.correoElectronico1;
			contribuyente.correoElectronico2 = e.correoElectronico2;
			Guardar(contribuyente);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Eliminar(Long id){
		try{
			contribuyenteRepository.deleteById(id);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public Contribuyente ObtenerPorId(Long id) {
		try {
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
}
