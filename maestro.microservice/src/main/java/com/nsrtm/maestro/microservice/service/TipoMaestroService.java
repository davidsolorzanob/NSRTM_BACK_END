package com.nsrtm.maestro.microservice.service;
import com.nsrtm.maestro.microservice.util.ResponseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nsrtm.maestro.microservice.domain.TipoMaestro;
import com.nsrtm.maestro.microservice.repository.TipoMaestroRepository;

@Service
public class TipoMaestroService {
	private static final Logger logger = LogManager.getLogger(TipoMaestroService.class);

	@Autowired
	private TipoMaestroRepository tipoMaestroRepository;

	public ResponseEntity<Object> Guardar(TipoMaestro e) {
		tipoMaestroRepository.save(e);
		return ResponseService.setResponse(true, HttpStatus.OK, "El registro se guardó satisfactoriamente", e);
	}

	public ResponseEntity<Object> Actualizar(TipoMaestro e){
		TipoMaestro tipoDb = ObtenerPorId(e.tipoMaestroId);
		tipoDb.nombre = e.nombre;
		tipoMaestroRepository.save(e);
		return ResponseService.setResponse(true, HttpStatus.OK, "El registro se actualizó satisfactoriamente", tipoDb);
	}

	public void Eliminar(Integer id){
		try{
			tipoMaestroRepository.deleteById(id);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public TipoMaestro ObtenerPorId(Integer id) {
		try {
			return tipoMaestroRepository.findById(id).get();
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public List<TipoMaestro> Todos(){
		return tipoMaestroRepository.findAll();
	}

	public TipoMaestro TodosTest(Integer id) {
		try {
			TipoMaestro m =tipoMaestroRepository.findById(id).get();
			return m;
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}
}
