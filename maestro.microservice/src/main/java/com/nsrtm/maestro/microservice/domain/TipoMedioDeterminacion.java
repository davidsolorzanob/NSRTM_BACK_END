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
@Table(name ="MED_DETERMINACION_TIPO", schema = "NSRTM")
public class TipoMedioDeterminacion extends Auditoria
{
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIP_MED_DETERMINA_ID")
    public Integer tipoMedioDeterminacionId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;

    public TipoMedioDeterminacion() {
    }

    public TipoMedioDeterminacion(Integer id, String descripcion, String abreviatura) {
        this.tipoMedioDeterminacionId = id;
        this.descripcion=descripcion;
        this.abreviatura = abreviatura;
    }
}