package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.ContactoContribuyente;

import java.util.List;

public interface ContactoContribuyenteCustomRepository {
    ContactoContribuyente CrearContacto(ContactoContribuyente custom);
    List<ContactoContribuyente> CrearContactoLista(Long municipalidadId, Long contribuyenteNumero, List<ContactoContribuyente> lista);
    ContactoContribuyente ActualizarContacto(ContactoContribuyente custom);
    boolean EliminarContacto(Long municipalidadId, Long contribuyenteNumero, Long contactoContribuyenteId, Long usuarioRegistro, String terminalRegistro) ;
    List<ContactoContribuyente> ListaContacto(Long municipalidadId, Long contribuyenteNumero);
}
