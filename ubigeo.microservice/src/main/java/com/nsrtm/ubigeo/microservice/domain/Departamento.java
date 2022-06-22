package com.nsrtm.ubigeo.microservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DEPARTAMENTO", schema = "NSRTM")
public class Departamento extends Auditoria {
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Long departamentoId;

    @Column(name = "UBIGEO")
    public String ubigeo;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

}