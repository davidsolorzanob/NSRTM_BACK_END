package com.nsrtm.contribuyente.microservice.domain;

import java.io.Serializable;

public class RelacionadoId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long relContribuyenteNumero;

    public RelacionadoId() {
    }

    public RelacionadoId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.relContribuyenteNumero = relContribuyenteNumero;
    }
}