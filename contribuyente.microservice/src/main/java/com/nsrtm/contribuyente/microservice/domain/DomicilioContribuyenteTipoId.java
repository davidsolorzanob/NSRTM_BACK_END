package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class DomicilioContribuyenteTipoId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long domicilioContribuyenteNumero;

    public Long tipoDomicilioId;

    public DomicilioContribuyenteTipoId() {
    }

    public DomicilioContribuyenteTipoId(Long municipalidadId, Long contribuyenteNumero, Long domicilioContribuyenteNumero, Long tipoDomicilioId) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.domicilioContribuyenteNumero = domicilioContribuyenteNumero;
        this.tipoDomicilioId = tipoDomicilioId;
    }
}
