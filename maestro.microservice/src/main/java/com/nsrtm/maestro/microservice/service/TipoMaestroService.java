package com.nsrtm.maestro.microservice.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsrtm.maestro.microservice.domain.TipoMaestro;
import com.nsrtm.maestro.microservice.repository.TipoMaestroRepository;

@Service
public class TipoMaestroService {
	private static final Logger logger = LogManager.getLogger(TipoMaestroService.class);

	@Autowired
	private TipoMaestroRepository tipoMaestroRepository;

	public TipoMaestro Guardar(TipoMaestro e) {
		return tipoMaestroRepository.save(e);
	}

	public void Actualizar(TipoMaestro e){
		try {
			TipoMaestro tipoDb = ObtenerPorId(e.tipoMaestroId);
			tipoDb.nombre = e.nombre;
			Guardar(tipoDb);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Eliminar(Integer id){
		tipoMaestroRepository.deleteById(id);
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

}
