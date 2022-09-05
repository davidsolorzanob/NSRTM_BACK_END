package com.nsrtm.contribuyente.reportes.domain;

import java.io.Serializable;

public class RelacionadoId implements Serializable {
    public Long municipalidadId;

    public Long contribuyenteNumero;

    public Long relContribuyenteNumero;

    public Long numeroDJ;

    public RelacionadoId() {
    }

    public RelacionadoId(Long municipalidadId, Long contribuyenteNumero, Long relContribuyenteNumero, Long numeroDJ) {
        this.municipalidadId = municipalidadId;
        this.contribuyenteNumero = contribuyenteNumero;
        this.relContribuyenteNumero = relContribuyenteNumero;
        this.numeroDJ = numeroDJ;
    }
}