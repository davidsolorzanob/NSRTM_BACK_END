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
@Table(name ="MED_DETERMINACION", schema = "NSRTM")
public class MedioDeterminacion extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIP_MED_DETERMINA_ID")
    public Integer tipoMedioDeterminacionId;


    @Column(name = "MED_DETERMINA_ID")
    public Integer medioDeterminacionId;

    @Column(name = "DES_MED_DETERMINA")
    public String desMedDetermina;

    public MedioDeterminacion() {
    }

    public MedioDeterminacion(Integer tipoMedioDeterminacionId, Integer medioDeterminacionId, String desMedDetermina) {
        this.tipoMedioDeterminacionId = tipoMedioDeterminacionId;
        this.desMedDetermina=desMedDetermina;
        this.medioDeterminacionId = medioDeterminacionId;
    }
}