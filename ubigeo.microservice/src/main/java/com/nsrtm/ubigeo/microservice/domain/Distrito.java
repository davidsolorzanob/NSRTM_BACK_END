package com.nsrtm.ubigeo.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DISTRITO", schema = "NSRTM")
public class Distrito extends Auditoria {
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Long departamentoId;

    @Column(name = "PROVINCIA_ID")
    public Long provinciaId;

    @Column(name = "DISTRITO_ID")
    public Long distritoId;

    @Column(name = "UBIGEO")
    public String ubigeo;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    @Column(name = "ACTIVO")
    public Integer activo;
}

