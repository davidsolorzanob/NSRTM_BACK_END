package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;

@Entity
@Table(name="REL_TIPO_PERSONA_TIPO", schema = "NSRTM")
public class TipoRelacionado {
    @Id
    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "DESCRIPCION")
    public String descripcion;

    @Column(name = "ABREVIATURA")
    public String abreviatura;
}
