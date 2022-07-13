package com.nsrtm.via.microservice.domain.complex;

import java.io.Serializable;

public class UbicacionId implements Serializable {
    public Integer departamentoId;

    public Integer provinciaId;

    public Integer distritoId;

    public Long ubicacionId;

    public UbicacionId() {

    }

    public UbicacionId(Integer departamentoId, Integer provinciaId, Integer distritoId, Long ubicacionId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
        this.ubicacionId = ubicacionId;
    }
}
