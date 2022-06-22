package com.nsrtm.ubigeo.microservice.domain;

import java.io.Serializable;

public class ProvinciaId implements Serializable {
    public Long departamentoId;

    public Long provinciaId;

    public ProvinciaId() {
    }

    public ProvinciaId(Long departamentoId, Long provinciaId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
    }
}
