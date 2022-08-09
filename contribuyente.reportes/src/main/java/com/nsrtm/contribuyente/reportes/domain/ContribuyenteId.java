package com.nsrtm.contribuyente.reportes.domain;

import java.io.Serializable;

public class ContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public ContribuyenteId() {
    }

    public ContribuyenteId(Long municipalidadId, Long contribuyenteNumero) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
    }
}
