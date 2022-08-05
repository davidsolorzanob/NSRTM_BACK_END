package com.nsrtm.contribuyente.microservice.repository;
import com.nsrtm.contribuyente.microservice.domain.DomicilioContribuyente;
import com.nsrtm.contribuyente.microservice.domain.complex.DomicilioContribuyenteCustom;
import java.util.List;

public interface DomicilioContribuyenteCustomRepository {
    DomicilioContribuyente CrearDomicilioContribuyente(DomicilioContribuyente custom);
    List<DomicilioContribuyente> CrearDomicilioContribuyenteLista(Long municipalidadId, Long contribuyenteNumero, List<DomicilioContribuyente> lista);
    DomicilioContribuyente ActualizarDomicilioContribuyente(DomicilioContribuyente custom);
    DomicilioContribuyenteCustom ObtenerDomicilioContribuyente(Long municipalidadId, Long contribuyenteNumero);
    List<DomicilioContribuyenteCustom> ListaDomicilioContribuyente(Long municipalidadId, Long contribuyenteNumero);
    boolean EliminarDomicilioContribuyente(Long municipalidadId, Long contribuyenteNumero, Long domContribuyenteNumero);
}
