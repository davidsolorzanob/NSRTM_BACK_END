package com.nsrtm.contribuyente.microservice.service;

import java.util.List;
import java.util.Locale;

import com.nsrtm.contribuyente.microservice.domain.Domicilio;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.nsrtm.contribuyente.microservice.domain.Contribuyente;
import com.nsrtm.contribuyente.microservice.repository.ContribuyenteRepository;

@Service
public class ContribuyenteService {
	private static final Logger logger = LogManager.getLogger(ContribuyenteService.class);

	@Autowired
	private ContribuyenteRepository contribuyenteRepository;

	public void Guardar(Contribuyente e) {
		try{
			contribuyenteRepository.save(e);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Actualizar(Contribuyente e){
		try {
			Contribuyente contribuyente = ObtenerPorId(e.contribuyenteId);
			contribuyente.codigo = e.codigo;
			contribuyente.contribuyenteId = e.contribuyenteId;
			contribuyente.secEjec = e.secEjec;
			contribuyente.tipoDocumento = e.tipoDocumento;
			contribuyente.tipoContribuyenteId = e.tipoContribuyenteId;
			contribuyente.numeroDocumento = e.numeroDocumento;
			contribuyente.apellidoPaterno = e.apellidoPaterno;
			contribuyente.apellidoMaterno = e.apellidoMaterno;
			contribuyente.nombres = e.nombres;
			contribuyente.razonSocial = e.razonSocial;
			contribuyente.celular1 = e.celular1;
			contribuyente.celular2 = e.celular2;
			contribuyente.correoElectronico1 = e.correoElectronico1;
			contribuyente.correoElectronico2 = e.correoElectronico2;
			Guardar(contribuyente);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public void Eliminar(Long id){
		try{
			contribuyenteRepository.deleteById(id);
		}
		catch (Exception ex){
			logger.info(ex.getMessage());
			throw ex;
		}
	}

	public Contribuyente ObtenerPorId(Long id) {
		try {
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

	//public List<Contribuyente> ListarPorFiltros(Contribuyente e){
		//return contribuyenteRepository.findByContribuyente(e.tipoDocumento, e.numeroDocumento, e.secEjec,e.apellidoPaterno);
		//return contribuyenteRepository.findBytipoDocumentoAndnumeroDocumentoAndsecEjec(e.tipoDocumento, e.numeroDocumento, e.secEjec);
		//Specification<Contribuyente> spec =
		//return contribuyenteRepository.findByTipoDocumentoAndNumeroDocumentoAndSecEjec(e.tipoDocumento, e.numeroDocumento, e.secEjec);
	//}

	private static Specification<Contribuyente> getByApellidoPaterno(String apellidoPaterno) {
		if(apellidoPaterno == null) return null;
		if(apellidoPaterno.isEmpty() || apellidoPaterno.isBlank()) return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("apellidoPaterno")), "%" + apellidoPaterno.toUpperCase(Locale.ROOT) + "%");
	}

	private static Specification<Contribuyente> getByApellidoMaterno(String apellidoMaterno) {
		if(apellidoMaterno == null) return null;
		if(apellidoMaterno.isEmpty() || apellidoMaterno.isBlank()) return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("apellidoMaterno")), "%" + apellidoMaterno.toUpperCase(Locale.ROOT) + "%");
	}

	private static Specification<Contribuyente> getByNombres(String nombres) {
		if(nombres == null) return null;
		if(nombres.isEmpty() || nombres.isBlank()) return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("nombres")),"%" + nombres.toUpperCase(Locale.ROOT) + "%");
	}

	private static Specification<Contribuyente> getByCodigo(String codigo) {
		if(codigo == null) return null;
		if(codigo.isEmpty() || codigo.isBlank()) return null;
		return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("codigo"), codigo);
	}

	public List<Contribuyente> ListarPorFiltros(Contribuyente e){
		Specification<Contribuyente> spec = null;
		Specification<Contribuyente> specTemp = getByApellidoPaterno(e.apellidoPaterno);
		specTemp = specTemp==null ? getByApellidoMaterno(e.apellidoMaterno):specTemp.and(getByApellidoMaterno(e.apellidoMaterno));
		specTemp = specTemp==null ? getByNombres(e.nombres):specTemp.and(getByNombres(e.nombres));
		specTemp = specTemp==null ? getByCodigo(e.codigo):specTemp.and(getByCodigo(e.codigo));
		spec = Specification.where(specTemp);
		if(spec == null)
			return contribuyenteRepository.findAll();
		return contribuyenteRepository.findAll(spec);
	}
}
