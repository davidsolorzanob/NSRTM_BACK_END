package com.nsrtm.maestro.microservice.service;

import java.util.List;

import com.nsrtm.maestro.microservice.domain.TipoMaestro;
import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.nsrtm.maestro.microservice.domain.Maestro;
import com.nsrtm.maestro.microservice.repository.MaestroRepository;

@Service
public class MaestroService {
	@Autowired
	private MaestroRepository maestroRepository;
	
	public Maestro Guardar(Maestro e) {
		return maestroRepository.save(e);
	}

	public void Actualizar(Maestro e){
		try {
			Maestro tipoDb = ObtenerPorId(e.maestroId);
			tipoDb.nombre = e.nombre;
			Guardar(tipoDb);
		}
		catch (Exception ex){
			throw ex;
		}
	}

	public void Eliminar(Integer id){
		maestroRepository.deleteById(id);
	}

	public Maestro ObtenerPorId (Integer id) {
		return maestroRepository.findById(id).get();
	}

	public List<Maestro> ObtenerPorFiltro (Maestro e) {
		Maestro m = Maestro.builder().tipoMaestroId(e.tipoMaestroId).build();
		return maestroRepository.findAll(Example.of(m));
	}

	public List<Maestro> Todos(){
		return maestroRepository.findAll();
	}
}
