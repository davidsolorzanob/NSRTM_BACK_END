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
@Table(name ="TIPO_CONTRIBUYENTE", schema = "NSRTM")
public class TipoContribuyente extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIP_CONTRIBUYENTE_ID")
    public Integer tipoContribuyenteId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public TipoContribuyente() {
    }

    public TipoContribuyente(Integer tipoContribuyenteId, String descripcion, String abreviatura) {
        this.tipoContribuyenteId = tipoContribuyenteId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}