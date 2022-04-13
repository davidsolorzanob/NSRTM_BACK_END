package com.nsrtm.maestro.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import com.nsrtm.maestro.microservice.domain.Maestro;
import com.nsrtm.maestro.microservice.repository.MaestroRepository;

@Service
public class MaestroService {
	private static final Logger logger = LogManager.getLogger(MaestroService.class);

	@Autowired
	private MaestroRepository maestroRepository;
	
	public void Guardar(Maestro e) {
		try
		{
			maestroRepository.save(e);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Actualizar(Maestro e){
		try {
			Maestro tipoDb = ObtenerPorId(e.maestroId);
			tipoDb.nombre = e.nombre;
			Guardar(tipoDb);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Eliminar(Integer id){
		try {
			maestroRepository.deleteById(id);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public Maestro ObtenerPorId (Integer id) {
		try{
			return maestroRepository.findById(id).get();
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public List<Maestro> ObtenerPorFiltro (Maestro e) {
		try{
			Maestro m = Maestro.builder().tipoMaestroId(e.tipoMaestroId).build();
			return maestroRepository.findAll(Example.of(m));
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public List<Maestro> Todos(){
		return maestroRepository.findAll();
	}
}
