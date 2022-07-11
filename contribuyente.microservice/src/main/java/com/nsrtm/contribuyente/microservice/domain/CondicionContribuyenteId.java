package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class CondicionContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long conContribuyenteNumero;

    public CondicionContribuyenteId() {
    }

    public CondicionContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long conContribuyenteNumero) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.conContribuyenteNumero = conContribuyenteNumero;
    }
}
