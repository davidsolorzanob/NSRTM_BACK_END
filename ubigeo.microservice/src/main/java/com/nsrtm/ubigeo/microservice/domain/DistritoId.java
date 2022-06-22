package com.nsrtm.ubigeo.microservice.domain;

import java.io.Serializable;

public class DistritoId implements Serializable {
    public Long departamentoId;

    public Long provinciaId;

    public Long distritoId;

    public DistritoId() {
    }

    public DistritoId(Long departamentoId, Long provinciaId,Long distritoId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
    }
}