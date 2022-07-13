package com.nsrtm.via.microservice.service;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;
import com.nsrtm.via.microservice.repository.ViaRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZonaService {
    private static final Logger logger = LogManager.getLogger(ViaService.class);

    @Autowired
    private ViaRepository viaRepository;

    public List<Ubicacion> ListaZonaUrbana(Ubicacion custom){
        return viaRepository.ListaZonaUrbana(custom);
    }

    public List<Ubicacion> ListaSubZonaUrbana(Ubicacion custom){
        return viaRepository.ListaSubZonaUrbana(custom);
    }
}
