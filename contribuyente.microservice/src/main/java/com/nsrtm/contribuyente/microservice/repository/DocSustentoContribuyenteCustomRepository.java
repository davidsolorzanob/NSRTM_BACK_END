package com.nsrtm.contribuyente.microservice.repository;

import com.nsrtm.contribuyente.microservice.domain.DocSustentoContribuyente;
import java.util.List;

public interface DocSustentoContribuyenteCustomRepository {
    DocSustentoContribuyente CrearDocSustento(DocSustentoContribuyente custom);
    List<DocSustentoContribuyente> CrearContactoLista(Long municipalidadId, Long contribuyenteNumero, List<DocSustentoContribuyente> lista);
    DocSustentoContribuyente ActualizarDocSustento(DocSustentoContribuyente custom) ;
    boolean EliminarDocSustento(Long municipalidadId, Long contribuyenteNumero, Long docSustentoId, Long usuarioRegistro, String terminalRegistro);
    List<DocSustentoContribuyente> ListaDocSustento(Long municipalidadId, Long contribuyenteNumero);
}