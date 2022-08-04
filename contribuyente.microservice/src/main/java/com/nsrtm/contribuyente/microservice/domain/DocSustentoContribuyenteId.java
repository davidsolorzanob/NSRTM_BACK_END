package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class DocSustentoContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long docSustentoId;

    public DocSustentoContribuyenteId() {
    }

    public DocSustentoContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long docSustentoId) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.docSustentoId = docSustentoId;
    }
}
