package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class CondicionContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long conContribuyenteId;

    public CondicionContribuyenteId() {
    }

    public CondicionContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long conContribuyenteId) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.conContribuyenteId = conContribuyenteId;
    }
}
