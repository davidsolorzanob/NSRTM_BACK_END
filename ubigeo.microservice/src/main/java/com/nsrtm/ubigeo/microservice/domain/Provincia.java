package com.nsrtm.ubigeo.microservice.domain;

import javax.persistence.*;

@Entity
@Table(name="PROVINCIA", schema = "NSRTM")
@IdClass(ProvinciaId.class)
public class Provincia extends Auditoria {
    @Id
    @Column(name = "DEPARTAMENTO_ID")
    public Long departamentoId;

    @Id
    @Column(name = "PROVINCIA_ID")
    public Long provinciaId;

    @Column(name = "UBIGEO")
    public String ubigeo;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

}
