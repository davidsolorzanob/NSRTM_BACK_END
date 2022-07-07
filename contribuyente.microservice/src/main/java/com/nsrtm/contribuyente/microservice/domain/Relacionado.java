package com.nsrtm.contribuyente.microservice.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="REL_CONTRIBUYENTE", schema = "NSRTM")
@IdClass(RelacionadoId.class)
public class Relacionado extends Auditoria {

    @Id
    @Column(name = "MUNICIPALIDAD_ID")
    public Long municipalidadId;

    @Id
    @Column(name = "CONTRIBUYENTE_NUMERO")
    public Long contribuyenteNumero;

    @Id
    @Column(name = "REL_CONTRIBUYENTE_NUMERO")
    public Long relContribuyenteNumero;

    @Column(name = "PERSONA_ID")
    public Long personaId;

    @Column(name = "TIP_RELACIONADO_ID")
    public Integer tipoRelacionadoId;

    @Column(name = "FEC_INSCRIPCION")
    public Date fechaInscripcion;

    @Column(name = "FEC_VIG_INICIAL")
    public Date fechaVigenciaInicial;

    @Column(name = "FEC_VIG_FINAL")
    public Date fechaVigenciaFinal;

    @Column(name = "ESTADO_ID")
    public Integer estadoId;

    @Column(name = "EST_CIVIL_TIP_ID")
    public Integer estadoCivil;
}
