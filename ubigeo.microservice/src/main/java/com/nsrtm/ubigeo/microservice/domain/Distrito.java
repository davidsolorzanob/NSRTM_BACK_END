package com.nsrtm.ubigeo.microservice.domain;

import javax.persistence.*;

@Entity
@Table(name="DISTRITO", schema = "NSRTM")
@IdClass(DistritoId.class)
public class Distrito extends Auditoria {
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Long departamentoId;

    @Id
    @Column(name = "PROVINCIA_ID")
    public Long provinciaId;

    @Id
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

