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
@Table(name ="ZONA_URBANA", schema = "NSRTM")
public class ZonaUrbana extends Auditoria
{
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;


    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;


    @Column(name = "DISTRITO_ID")
    public Integer distritoId;


    @Column(name = "ZONA_URBANA_ID")
    public Integer zonaUrbanaId;

    @Column(name = "DES_ZONA_URBANA")
    public String desZonaUrbana;

    @Column(name = "TIP_ZONA_URBANA_ID")
    public Integer tipoZonaUrbanaId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    public ZonaUrbana() {
    }

    public ZonaUrbana(Integer departamentoId, Integer provinciaId, Integer distritoId, Integer zonaUrbanaId, String desZonaUrbana, Integer tipoZonaUrbanaId, Integer estadoId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
        this.zonaUrbanaId=zonaUrbanaId;
        this.desZonaUrbana = desZonaUrbana;
        this.tipoZonaUrbanaId = tipoZonaUrbanaId;
        this.estadoId = estadoId;
    }
}