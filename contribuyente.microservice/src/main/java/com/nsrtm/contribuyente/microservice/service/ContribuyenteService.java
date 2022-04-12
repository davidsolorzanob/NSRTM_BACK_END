package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.repository.ContribuyenteRepository;

@Service
public class ContribuyenteService {
	
	@Autowired
	private ContribuyenteRepository contribuyenteRepository;
	
	public Contribuyente Create(Contribuyente e) {
		return contribuyenteRepository.save(e);
	}
	
	public List<Contribuyente> getAllContribuyente(){
		return contribuyenteRepository.findAll();
	}
}
