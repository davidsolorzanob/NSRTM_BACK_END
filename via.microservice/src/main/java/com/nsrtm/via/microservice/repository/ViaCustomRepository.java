package com.nsrtm.via.microservice.repository;

import com.nsrtm.via.microservice.domain.complex.Ubicacion;

import java.util.List;

public interface ViaCustomRepository {
    public List<Ubicacion> ListaVia(Ubicacion custom);
    public List<Ubicacion> ListaZonaUrbana(Ubicacion custom);
    public List<Ubicacion> ListaSubZonaUrbana(Ubicacion custom);
}
