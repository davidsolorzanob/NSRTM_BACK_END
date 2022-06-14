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
@Table(name ="SUBZONA_URBANA", schema = "NSRTM")
public class SubZonaUrbana extends Auditoria
{
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;


    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;


    @Column(name = "DISTRITO_ID")
    public Integer distritoId;


    @Column(name = "SUBZONA_URBANA_ID")
    public Integer subZonaUrbanaId;

    @Column(name = "DES_SUBZONA_URBANA")
    public String desSubZonaUrbana;

    @Column(name = "TIP_SUBZONA_URBANA_ID")
    public Integer tipoSubZonaUrbanaId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    public SubZonaUrbana() {
    }

    public SubZonaUrbana(Integer departamentoId, Integer provinciaId, Integer distritoId, Integer subZonaUrbanaId, String desSubZonaUrbana, Integer tipoSubZonaUrbanaId, Integer estadoId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
        this.subZonaUrbanaId=subZonaUrbanaId;
        this.desSubZonaUrbana = desSubZonaUrbana;
        this.tipoSubZonaUrbanaId = tipoSubZonaUrbanaId;
        this.estadoId = estadoId;
    }
}