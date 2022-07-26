package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteCustom;
import com.nsrtm.contribuyente.microservice.domain.complex.ContribuyenteResult;
import com.nsrtm.contribuyente.microservice.util.PageRequest;
import com.nsrtm.contribuyente.microservice.util.PageResponse;

import java.util.List;

public interface ContribuyenteCustomRepository {

    ContribuyenteCustom CrearContribuyente(ContribuyenteCustom custom);
    ContribuyenteCustom ActualizarContribuyente(ContribuyenteCustom custom);
    ContribuyenteCustom ObtenerContribuyente(Long municipalidadId, Long contribuyenteNumero);
    PageResponse<List<ContribuyenteResult>> ListaContribuyentePaginado(PageRequest<ContribuyenteCustom> custom);
    boolean EliminarContribuyente(Long municipalidadId, Long contribuyenteNumero);
    List<ContribuyenteResult> ListaContribuyenteReporte(ContribuyenteCustom custom);
}
