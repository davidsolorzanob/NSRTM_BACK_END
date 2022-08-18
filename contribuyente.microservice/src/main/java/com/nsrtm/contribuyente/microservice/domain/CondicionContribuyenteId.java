package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class CondicionContribuyenteId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long conContribuyenteId;

    public Long numeroDJ;
    public CondicionContribuyenteId() {
    }

    public CondicionContribuyenteId(Long municipalidadId, Long contribuyenteNumero, Long conContribuyenteId, Long numeroDJ) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.conContribuyenteId = conContribuyenteId;
        this.numeroDJ = numeroDJ;
    }
}
