package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.Column;
import java.io.Serializable;

public class DomicilioRelacionadoId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long relContribuyenteNumero;

    public Long domicilioRelacionadoNumero;

    public DomicilioRelacionadoId() {
    }

    public DomicilioRelacionadoId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero, Long domicilioRelacionadoNumero) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.relContribuyenteNumero = relContribuyenteNumero;
        this.domicilioRelacionadoNumero = domicilioRelacionadoNumero;
    }
}
