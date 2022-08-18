package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class ContactoContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long contactoContribuyenteId;
    public Long numeroDJ;
    public ContactoContribuyenteId() {
    }

    public ContactoContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long contactoContribuyenteId, Long numeroDJ) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.contactoContribuyenteId = contactoContribuyenteId;
        this.numeroDJ = numeroDJ;
    }
}
