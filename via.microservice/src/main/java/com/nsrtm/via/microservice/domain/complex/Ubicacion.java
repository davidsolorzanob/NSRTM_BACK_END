package com.nsrtm.via.microservice.domain.complex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UbicacionId.class)
public class Ubicacion {

    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Integer departamentoId;

    @Id
    @Column(name = "PROVINCIA_ID")
    public Integer provinciaId;

    @Id
    @Column(name = "DISTRITO_ID")
    public Integer distritoId;

    @Id
    @Column(name = "ID")
    public Long ubicacionId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    @Column(name = "ID_ANTERIOR")
    public Long anteriorId;

    @Column(name = "TIPO")
    public Long tipo;
}
