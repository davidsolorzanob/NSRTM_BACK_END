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
@Table(name ="RELACIONADO_TIPO", schema = "NSRTM")
public class TipoRelacionado extends Auditoria
{
    @Id
    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public TipoRelacionado() {
    }

    public TipoRelacionado(Integer tipoRelacionadoId, String descripcion, String abreviatura) {
        this.tipoRelacionadoId = tipoRelacionadoId;
        this.descripcion = descripcion;
        this.abreviatura = abreviatura;
    }
}