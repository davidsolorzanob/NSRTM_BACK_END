package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ContribuyenteCustomRepository {

    ContribuyenteCustom CrearContribuyente(ContribuyenteCustom custom);
    ContribuyenteCustom ActualizarContribuyente(ContribuyenteCustom custom);
    PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom);

}
