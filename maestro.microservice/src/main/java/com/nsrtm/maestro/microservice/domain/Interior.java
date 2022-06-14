package com.nsrtm.maestro.microservice.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@Builder
@Entity
@Table(name ="INTERIOR_TIPO", schema = "NSRTM")
public class Interior extends Auditoria
{
    @Id
    @Column(name = "EDIFICACION_ID")
    public Integer tipoInteriorId;

    @Column(name = "DES_TIP_INTERIOR")
    public String desTipoInterior;

     public Interior() {
    }

    public Interior(Integer tipoInteriorId, String desTipoInterior) {
        this.tipoInteriorId = tipoInteriorId;
        this.desTipoInterior = desTipoInterior;
    }
}