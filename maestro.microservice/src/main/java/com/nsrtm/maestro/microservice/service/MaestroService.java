package com.nsrtm.maestro.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nsrtm.maestro.microservice.domain.Maestro;
import com.nsrtm.maestro.microservice.repository.MaestroRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class MaestroService {
	private static final Logger logger = LogManager.getLogger(MaestroService.class);

	@Autowired
	private MaestroRepository maestroRepository;

	public List<Maestro> ObtenerPorFiltro (int tipoMaestroId) {
		return maestroRepository.ObtenerMaestro(tipoMaestroId);
	}

}
