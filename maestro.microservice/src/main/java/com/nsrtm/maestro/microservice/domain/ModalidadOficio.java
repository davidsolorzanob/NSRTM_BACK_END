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
@Table(name ="MODALIDAD_OFICIO", schema = "NSRTM")
public class ModalidadOficio extends Auditoria
{
    @Id
    @Column(name = "MOD_OFICIO_ID")
    public Integer modalidadOficioId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public ModalidadOficio() {
    }

    public ModalidadOficio(Integer modalidadOficioId, String descripcion, String abreviatura) {
        this.modalidadOficioId = modalidadOficioId;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}