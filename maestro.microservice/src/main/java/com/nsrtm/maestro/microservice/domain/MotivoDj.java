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
@Table(name ="MOTIVO_DJ", schema = "NSRTM")
public class MotivoDj extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOTIVO_DJ_ID")
    public Integer motivoDjId;


    @Column(name = "DES_MOTIVO_DJ")
    public String desMotivoDj;

    @Column(name = "DES_ABR_MOTIVO_DJ")
    public String desAbrMotivo;

    public MotivoDj() {
    }

    public MotivoDj(Integer motivoDjId, String desMotivoDj, String desAbrMotivo) {
        this.motivoDjId = motivoDjId;
        this.desMotivoDj=desMotivoDj;
        this.desAbrMotivo = desAbrMotivo;
    }
}