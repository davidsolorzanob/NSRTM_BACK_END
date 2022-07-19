package com.nsrtm.via.microservice.repository;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;

import java.util.List;

public interface ViaCustomRepository {
    List<Ubicacion> ListaVia(Ubicacion custom);
    List<Ubicacion> ListaZonaUrbana(Ubicacion custom);
    List<Ubicacion> ListaSubZonaUrbana(Ubicacion custom);
    List<Ubicacion> ListaEdificacion(Ubicacion custom);
}
