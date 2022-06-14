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
@Table(name ="EDIFICACION", schema = "NSRTM")
public class Edificacion extends Auditoria
{
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;
    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;


    @Column(name = "DISTRITO_ID")
    public Integer distritoId;


    @Column(name = "EDIFICACION_ID")
    public Integer edificacionId;

    @Column(name = "DES_EDIFICACION")
    public String desEdificacion;

    @Column(name = "TIP_EDIFICACION_ID")
    public Integer tipoEdificacionId;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    public Edificacion() {
    }

    public Edificacion(Integer departamentoId, Integer provinciaId, Integer distritoId, Integer edificacionId, String desEdificacion, Integer tipoEdificacionId, Integer estadoId) {
        this.departamentoId = departamentoId;
        this.provinciaId = provinciaId;
        this.distritoId = distritoId;
        this.edificacionId=edificacionId;
        this.desEdificacion = desEdificacion;
        this.tipoEdificacionId = tipoEdificacionId;
        this.estadoId = estadoId;
    }
}