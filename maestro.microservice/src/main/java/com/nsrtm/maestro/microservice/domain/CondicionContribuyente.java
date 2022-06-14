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
@Table(name ="CON_CONTRIBUYENTE_TIPO", schema = "NSRTM")
public class CondicionContribuyente extends Auditoria{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_CONTRIBUYENTE_ID")
    public Integer condicionContribuyenteId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public CondicionContribuyente() {
    }

    public CondicionContribuyente(Integer condicionContribuyenteId, String descripcion, String abreviatura) {
        this.condicionContribuyenteId = condicionContribuyenteId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}


