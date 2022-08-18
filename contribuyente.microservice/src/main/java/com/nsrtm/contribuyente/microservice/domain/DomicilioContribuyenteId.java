package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class DomicilioContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long numeroDJ;

    public Long domicilioContribuyenteNumero;

    public DomicilioContribuyenteId() {
    }

    public DomicilioContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero, Long numeroDJ) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.domicilioContribuyenteNumero = domicilioContribuyenteNumero;
        this.numeroDJ = numeroDJ;
    }
}
