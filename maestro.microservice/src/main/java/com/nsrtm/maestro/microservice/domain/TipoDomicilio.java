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
@Table(name ="DOMICILIO_TIPO", schema = "NSRTM")
public class TipoDomicilio extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIP_DOMICILIO_ID")
    public Integer tipoDomicilioId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public TipoDomicilio() {
    }

    public TipoDomicilio(Integer tipoDomicilioId, String descripcion, String abreviatura) {
        this.tipoDomicilioId = tipoDomicilioId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}