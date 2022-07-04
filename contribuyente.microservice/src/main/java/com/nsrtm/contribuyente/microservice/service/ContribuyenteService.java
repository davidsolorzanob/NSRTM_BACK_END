package com.nsrtm.contribuyente.microservice.service;

import java.util.List;

import com.nsrtm.contribuyente.microservice.domain.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.ContribuyenteId;
import com.nsrtm.contribuyente.microservice.domain.Persona;
import com.nsrtm.contribuyente.microservice.repository.PersonaRepository;
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

	@Autowired
	private PersonaRepository personaRepository;

	public void Guardar(Contribuyente e) {
		try{
			contribuyenteRepository.save(e);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Crear(ContribuyenteCustom e){
		try {
			Contribuyente contribuyente = new Contribuyente();
			contribuyente.municipalidadId = e.municipalidadId;
			contribuyente.fechaInscripcion = e.fechaInscripcion;
			contribuyente.fechaDJ=e.fechaDJ;
			contribuyente.numeroDJ=e.numeroDJ;
			contribuyente.personaId=e.personaId;
			contribuyente.tipoPersonaId=e.tipoPersonaId;
			contribuyente.motivoDjId=e.motivoDjId;
			contribuyente.estadoDjId=e.estadoDjId;
			contribuyente.modalidadOficio=e.modalidadOficio;
			contribuyente.tipoMedioDeterminacionId=e.tipoMedioDeterminacionId;
			contribuyente.medioDeterminacionId=e.medioDeterminacionId;
			contribuyente.segContribuyenteId=e.segContribuyenteId;
			contribuyente.fuenteInformacionId=e.fuenteInformacionId;
			contribuyente.usuarioCreacion = e.usuarioCreacion;
			contribuyente.terminalCreacion = e.terminalCreacion;

			Persona persona =new Persona();
			persona.docIdentidadId= e.docIdentidadId;
			persona.numDocIdentidad=e.numDocIdentidad;
			persona.apellidoPaterno=e.apellidoPaterno;
			persona.apellidoMaterno=e.apellidoMaterno;
			persona.nombres=e.nombres;
			persona.razonSocial=e.razonSocial;
			persona.nombreCompleto=e.nombreCompleto;
			persona.fechaNacimiento=e.fechaNacimiento;
			persona.genero=e.genero;
			persona.fallecido=e.fallecido;
			persona.fechaFallecimiento=e.fechaFallecimiento;
			persona.usuarioCreacion = e.usuarioCreacion;
			persona.terminalCreacion = e.terminalCreacion;
			personaRepository.save(persona);

			contribuyente.personaId = persona.personaId;
			Guardar(contribuyente);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}


	public void Actualizar(ContribuyenteCustom e){
		try {
			Contribuyente contribuyente = ObtenerPorId(e.municipalidadId,e.contribuyenteNumero);
			contribuyente.fechaInscripcion = e.fechaInscripcion;
			contribuyente.fechaDJ=e.fechaDJ;
			contribuyente.numeroDJ=e.numeroDJ;
			contribuyente.personaId=e.personaId;
			contribuyente.tipoPersonaId=e.tipoPersonaId;
			contribuyente.motivoDjId=e.motivoDjId;
			contribuyente.estadoDjId=e.estadoDjId;
			contribuyente.modalidadOficio=e.modalidadOficio;
			contribuyente.tipoMedioDeterminacionId=e.tipoMedioDeterminacionId;
			contribuyente.medioDeterminacionId=e.medioDeterminacionId;
			contribuyente.segContribuyenteId=e.segContribuyenteId;
			contribuyente.fuenteInformacionId=e.fuenteInformacionId;
			contribuyente.usuarioCreacion = e.usuarioCreacion;
			contribuyente.terminalCreacion = e.terminalCreacion;

			Persona persona =personaRepository.getById(e.personaId);
			persona.docIdentidadId= e.docIdentidadId;
			persona.numDocIdentidad=e.numDocIdentidad;
			persona.apellidoPaterno=e.apellidoPaterno;
			persona.apellidoMaterno=e.apellidoMaterno;
			persona.nombres=e.nombres;
			persona.razonSocial=e.razonSocial;
			persona.nombreCompleto=e.nombreCompleto;
			persona.fechaNacimiento=e.fechaNacimiento;
			persona.genero=e.genero;
			persona.fallecido=e.fallecido;
			persona.fechaFallecimiento=e.fechaFallecimiento;
			persona.usuarioCreacion = e.usuarioCreacion;
			persona.terminalCreacion = e.terminalCreacion;
			personaRepository.save(persona);

			Guardar(contribuyente);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Eliminar(Long municipalidadId, Long contribuyenteNumero){
		try{
			ContribuyenteId id = new ContribuyenteId(municipalidadId,contribuyenteNumero);
			contribuyenteRepository.deleteById(id);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public Contribuyente ObtenerPorId(Long municipalidadId, Long contribuyenteNumero) {
		try {
			ContribuyenteId id = new ContribuyenteId(municipalidadId,contribuyenteNumero);
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
