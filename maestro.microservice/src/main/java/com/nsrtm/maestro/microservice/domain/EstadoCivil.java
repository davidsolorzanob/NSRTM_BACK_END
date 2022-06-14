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
@Table(name ="ESTADO_CIVIL", schema = "NSRTM")
public class EstadoCivil extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EST_CIVIL_ID")
    public Integer estadoCivilId;
    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public EstadoCivil() {
    }

    public EstadoCivil(Integer estadoCivilId, String descripcion, String abreviatura) {
        this.estadoCivilId = estadoCivilId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}