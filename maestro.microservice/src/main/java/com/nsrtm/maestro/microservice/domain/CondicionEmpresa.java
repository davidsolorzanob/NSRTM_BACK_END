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
@Table(name ="CON_EMPRESA_TIPO", schema = "NSRTM")
public class CondicionEmpresa extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CON_EMPRESA_ID")
    public Integer condicionEmpresaId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public CondicionEmpresa() {
    }

    public CondicionEmpresa(Integer condicionEmpresaId, String descripcion, String abreviatura) {
        this.condicionEmpresaId = condicionEmpresaId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}