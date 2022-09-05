package com.nsrtm.contribuyente.reportes.repository;

import com.nsrtm.contribuyente.reportes.domain.DocSustentoContribuyente;

import java.util.List;

public interface DocSustentoContribuyenteCustomRepository {
    List<DocSustentoContribuyente> ListaDocSustento(Long municipalidadId, Long contribuyenteNumero, Long numeroDJ);
}
